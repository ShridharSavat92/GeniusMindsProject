package com.geniusMinds;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NarayTreeNT {
	public static class TreeNode{
		Node val;
		List<TreeNode> children=new LinkedList<TreeNode>();
	
	}
	
	public static TreeNode buildNaryTree(Node [] nodes) {
		Stack<TreeNode> st=new Stack();
		TreeNode root = null;
		for(int i=0; i<nodes.length; i++) {
			if(nodes[i]==null) {
				st.pop();
			}else {
				TreeNode t=new TreeNode();
				t.val=nodes[i];
				if(st.size()>0) {
				st.peek().children.add(t);
				
				}else {
					root=t;
				}
				st.push(t);
			}
			
		}
		return root;
	}
	
	static List<Node> result=new ArrayList<>();
	public static List<Node> preOrder(TreeNode root){
		if(root==null) {
			return result;
		}
		preOrderHelper(root);
		return result;
	}
	
	public static void preOrderHelper(TreeNode node) {
		if(node.children==null) {
			return;
		}
		result.add(node.val);
		for(TreeNode child:node.children) {
			preOrderHelper(child);
		}
		
	}

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		List<Node> list=new ArrayList<>();
		File jsonFile=new File("C:\\Users\\Lenovo\\Node.json");
		list=mapper.readValue(jsonFile, new TypeReference<List<Node>>(){});
		
		Node [] nodes= {list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),null,null,list.get(5),list.get(6),list.get(7),list.get(8),null,null,null,null,null,list.get(9),null,null};
		TreeNode root=buildNaryTree(nodes);
		System.out.println("PreOrder NaryTree implementation: ");
		List<Node> ans=preOrder(root);
		for(Node n:ans) {
			System.out.print(n.toString()+" ");
		}
		
		System.out.println("\nExtracting edges of NaryTrees: ");
		ArrayList<Edge> edges=new ArrayList<>();
		for(int i=0; i<ans.size(); i++){
			for(int j=i+1; j<ans.size(); j++){
				Edge e=new Edge(ans.get(i).id+ans.get(j).id,ans.get(i).id,ans.get(j).id);
				edges.add(e);
			}
		}
		
		for(Edge e:edges) {
			System.out.print(e.toString()+" ");
		}
		
	}

}
