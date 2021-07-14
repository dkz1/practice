package TreeDemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * һ��������
 * ��Щ�������Զ���ɽӿ� ����Щ���Ը��ⲿ���ã���Щ���ܸ��ⲿ����
 * @author 1
 *
 */
public class Tree {
	
	private TreeNode root;

	public Tree(TreeNode root) {
		super();
		this.root = root;
	}

	public TreeNode getRoot() {
		return root;
	}

	/**
	 * ������   ��������Ӧ��д�������ط�ȥ����Tree����൥��һ��
	 * @param treenodes
	 */
	public void bulidTree(List<TreeNode> treenodes) {
		
		for(int i = 0;i < treenodes.size();i++) {
			for(int j = 0; j < treenodes.size(); j++) {
				if(treenodes.get(i).getId() == treenodes.get(j).getParentId()) {
					treenodes.get(i).addChild(treenodes.get(j));
				}
			}
		}
	}

	/**
	 * ����������ȱ��������������  
	 * @return	������˳�򷵻ؽڵ��Id ƴ�ӳɵ��ַ���
	 */
	public String depthFirstSearch() {
		// TODO ����ʵ��
		if(root == null) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<>();
		//�Ƚ����ڵ�ѹ��ջ
		stack.push(root);
		StringBuffer sb = new StringBuffer();
		//ջ��ʱ��ֹѭ��
		while(!stack.isEmpty()) {
			//ȡ��ջ���Ľڵ�
			TreeNode node = stack.pop();
			//��ʱ��ȡ���Ľڵ�IDappend��sb��
			sb.append(node.getId()+" ");
			if(node.getChildren() != null) {
				//���˽ڵ����ӽڵ�ʱ�����ҵ���Ľ��ӽڵ�ѹ��ջ�У�ԭ������Ϊջ�����ԣ�����ջ����ջ���Ϸ���
				for(int i = node.getChildren().size() - 1;i >= 0;i--) {
					stack.push(node.getChildren().get(i));
				}
			}
		}
		return sb.toString();
	}

	//TODO �ݹ�ı�����ʽ
	
	/**
	 * ���Ĺ�����ȱ���
	 */
	public void breathFirstSearch() {
		// TODO ����ʵ��
	}

	/**
	 * ��ȡ����������
	 * 
	 * @return
	 */
	public int getMaxDepth() {
		// TODO ����ʵ��
		return 0;
	}

	/**
	 * ��ȡ����ָ����Ľڵ����
	 * 
	 * @param level
	 * @return
	 */
	public int getLevelNodeNum(int level) {
		// TODO ����ʵ��
		return 0;
	}

	/**
	 * �����Ľṹд��json��ʽ���ַ�����Ȼ��ֱ��д��json�ļ�
	 * 
	 * @param tree
	 * @return
	 */
	public String printTree(Tree tree) {
		return null;
	}

	public static void main(String[] args) {
		Logger log = Logger.getLogger(Tree.class);
		//�ڵ��б�
		List<TreeNode> list = new ArrayList<>();
		//����json�ļ���ת�����ַ���
		String res = null;
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\Idea\\src\\TreeDemo\\nodes.json"))){
			StringBuffer sb = new StringBuffer();
			int len;
			byte[] b = new byte[1024];
			while ((len = bis.read(b)) != -1) {
				sb.append(new String(b,0,len));
			}
			res = sb.toString();

		} catch(Exception e){
			e.printStackTrace();
		}
		//��jackson�ķ�����json��ʽ�ַ������н�����ת����List<Map<String,Object>>����ʽ
		ObjectMapper objectMapper = new ObjectMapper();
		List<Map<String, String>> list2 = new ArrayList<Map<String, String>>();
		try {
			list2 = objectMapper.readValue(res, List.class);
			log.info(list2.toString()); //��ȡ�������ݸ�ʽ��{Id=1, Pid=0, name=���Ͽ��, children=[]} ��map����ʽ�洢
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < list2.size();i++) {
			TreeNode node = new TreeNode(Integer.parseInt(list2.get(i).get("Id")),Integer.parseInt(list2.get(i).get("Pid")),list2.get(i).get("name"));
			list.add(node);
		}
		log.info(list.toString());
		Tree tree = new Tree(list.get(0));
		tree.bulidTree(list);
		log.info(list.toString());

		//�ڵ����� ��ȡһ��json�ļ�(��ȡ���ļ��е������������޸��ӹ�ϵ�Ľڵ㣩�����ݽ��佨����һ������
		// �����б����ȷ����Ĳ���������ٽ������д�뵽��һ��json�ļ���ȥ��д���json�ļ����и��ӹ�ϵ������Ľڵ���Ϣ��
//		String[] namelist = {"1,0,���Ͽ��","List","Set","Map","ArrayList","LinkedList","Vector","HashSet"
//				,"SortedSet","HashMap","Hashtable","IdentityHashMap","SortedMap","WeakedHashMap"};
		//�� Id,Pid,nameΪ�ṹ��Ĭ��PidΪ0��Ϊ���ڵ�
	}

}
