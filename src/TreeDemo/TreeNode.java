package TreeDemo;

import java.util.ArrayList;
import java.util.List;

class TreeNode {

	private int Id;
	private int ParentId;
	private String name;
	private List<TreeNode> children = new ArrayList<>();
	
	

	public TreeNode() {
		super();
	}

	public TreeNode(int id, int parentId, String name) {
		Id = id;
		ParentId = parentId;
		this.name = name;
	}

	public int getId() {
		return Id;
	}

	public int getParentId() {
		return ParentId;
	}

	public String getName() {
		return name;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	@Override
	public String toString() {
		return "TreeNode{" +
				"Id=" + Id +
				", ParentId=" + ParentId +
				", name='" + name + '\'' +
				", children=" + children +
				'}';
	}

	/**
	 * 返回直接子节点
	 * 
	 * @return
	 */
	public List<TreeNode> listChildren() {
		return this.children;
	}

	public void addChild(TreeNode node){
		children.add(node);
	}
}