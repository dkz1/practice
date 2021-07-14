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
 * 一个树的类
 * 哪些方法可以定义成接口 ，哪些可以给外部调用，哪些不能给外部调用
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
	 * 创建树   创建方法应该写到其他地方去，让Tree这个类单纯一点
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
	 * 树的深度优先遍历（先序遍历）  
	 * @return	按遍历顺序返回节点的Id 拼接成的字符串
	 */
	public String depthFirstSearch() {
		// TODO 具体实现
		if(root == null) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<>();
		//先将根节点压入栈
		stack.push(root);
		StringBuffer sb = new StringBuffer();
		//栈空时终止循环
		while(!stack.isEmpty()) {
			//取出栈顶的节点
			TreeNode node = stack.pop();
			//此时将取出的节点IDappend到sb上
			sb.append(node.getId()+" ");
			if(node.getChildren() != null) {
				//当此节点有子节点时，从右到左的将子节点压入栈中（原因是因为栈的特性，后入栈的在栈最上方）
				for(int i = node.getChildren().size() - 1;i >= 0;i--) {
					stack.push(node.getChildren().get(i));
				}
			}
		}
		return sb.toString();
	}

	//TODO 递归的遍历方式
	
	/**
	 * 树的广度优先遍历
	 */
	public void breathFirstSearch() {
		// TODO 具体实现
	}

	/**
	 * 获取树的最大深度
	 * 
	 * @return
	 */
	public int getMaxDepth() {
		// TODO 具体实现
		return 0;
	}

	/**
	 * 获取树的指定层的节点个数
	 * 
	 * @param level
	 * @return
	 */
	public int getLevelNodeNum(int level) {
		// TODO 具体实现
		return 0;
	}

	/**
	 * 将树的结构写成json格式的字符串，然后直接写入json文件
	 * 
	 * @param tree
	 * @return
	 */
	public String printTree(Tree tree) {
		return null;
	}

	public static void main(String[] args) {
		Logger log = Logger.getLogger(Tree.class);
		//节点列表
		List<TreeNode> list = new ArrayList<>();
		//读入json文件，转换成字符串
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
		//用jackson的方法对json格式字符串进行解析，转换成List<Map<String,Object>>的形式
		ObjectMapper objectMapper = new ObjectMapper();
		List<Map<String, String>> list2 = new ArrayList<Map<String, String>>();
		try {
			list2 = objectMapper.readValue(res, List.class);
			log.info(list2.toString()); //读取到的数据格式：{Id=1, Pid=0, name=集合框架, children=[]} 以map的形式存储
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

		//节点内容 读取一个json文件(读取的文件中的数据是无序无父子关系的节点）的内容将其建立成一棵树，
		// 并进行遍历等方法的操作，最后再将这个树写入到另一个json文件中去（写入的json文件是有父子关系的有序的节点信息）
//		String[] namelist = {"1,0,集合框架","List","Set","Map","ArrayList","LinkedList","Vector","HashSet"
//				,"SortedSet","HashMap","Hashtable","IdentityHashMap","SortedMap","WeakedHashMap"};
		//以 Id,Pid,name为结构，默认Pid为0的为根节点
	}

}
