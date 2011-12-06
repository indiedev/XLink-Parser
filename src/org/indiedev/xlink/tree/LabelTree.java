package org.indiedev.xlink.tree;

import java.util.Iterator;
import java.util.Set;

/*
 * This is a Tree data-structure for representing label hierarchies.
 * Node type:LabelNode(which contains 'Locator').
 */
class LabelTree 
{
	private static int NODES_COUNT=0;
	private LabelNode rootNode;
	private static String TAB_SPACE="";

	
	//always specify the rootnode!
	LabelTree(LabelNode t_rootNode)
	{
		rootNode=t_rootNode;
		System.out.println("Created a LabelTree with ROOTNODE:"+t_rootNode.getNodeName());
		NODES_COUNT++;
	}
	
	public int getNodeCount()
	{
		return NODES_COUNT;
	}
	
	/*INSERTS THE GIVEN 'LABEL NODE' UNDER THE SPECIFIED 'PARENT NODE'
	 * Steps in inserting a node into this tree
	 * ------------------------------------------
	 * 1.Get the 't_parentNode' name and check whether it exists.
	 *   *IF-EXISTS:
	 *   	a.)add the 't_childnode' to it .[Eg: t_parentNode.addChildNode(t_childnode)].
	 * 			NOTE:It is not possible to add childnodes having same labelname.
	 *   *IF-NOTEXISTS:(this step is omitted for now)
	 *   	a.)Create the parent node 't_parentNode' and add to the ROOT Node.
	 *      b.)Then,add the childnode 't_childnode' to this new parent node.
	 */
	public boolean insertNode(LabelNode t_parentNode,LabelNode t_childnode)
	{
		if(rootNode==null)
		{
			rootNode=t_parentNode;
			t_parentNode.addChildNode(t_childnode);
			return true;
		}
		else//if rootnode exist.
		{
			//start searching the parentnode in the entire tree from ROOTNODE.
			//returns the parentnode.
			LabelNode t_node=searchNode(rootNode,t_parentNode);
			
			//check whether the parentNode is found
			if(t_node==null)//if not found
			{
				//PARENTNODE DOES NOT EXIST!
				//System.out.println("	ParentNode[ "+t_parentNode.getNodeName()+" ] does not exist!!");
				return false;
			}
			else//if the req.parent is found.
			{
					//adding the child node under parentNode(which exists)...
				t_node.addChildNode(t_childnode);
					
				System.out.println("	Node[ "+t_childnode.getNodeName()+" ] added to ParentNode[ "+t_node.getNodeName()+" ]");
				
				//increment nodes_count
				NODES_COUNT++;
				
				return true;
			}
		}
	}
	
	public void removeNode(LabelNode t_node)
	{
		//removes the node{not needed for now}
	}
	
	public void displayEntireTree()
	{
		if(rootNode==null)
		{
			System.out.println("Unable to display LabelTree.ROOTNODE is NULL!!");
		}
		else//if rootnode exist.
		{
			System.out.println("[DISPLAYING TREE]:RootNode:"+rootNode.getNodeName());

			display(rootNode);
		}
		System.out.println("***FINISHED DISPLAYING ENTIRE TREE***");

	}
	 
	/*
	 * Displays the child nodes under the specified node.
	 * Steps in displaying child nodes 
	 * -------------------------------
	 * 
	 */
	private void display(LabelNode t_rootNode)
	{
		//recursive
		System.out.println(TAB_SPACE+t_rootNode.getNodeName()+" : "+t_rootNode.getOrder());
		
		if(t_rootNode.hasChilds())
		{
			Set<LabelNode> tempChilds=t_rootNode.getChildNodes();			
			Iterator<LabelNode> itr=tempChilds.iterator();
			
			TAB_SPACE=TAB_SPACE+" ";
			
			//print the child node contents
			while(itr.hasNext())
			{
				display(itr.next());
			}
			TAB_SPACE=TAB_SPACE.substring(0, TAB_SPACE.length()-1);
		}
		
	}
	
	/*
	 * Searches a given node 't_node' from a given starting node 't_parentNode' and its childnodes.
	 * if childnodes has its own childs, then it is searched recursively
	 */
	public LabelNode searchNode(LabelNode t_startNode, LabelNode t_nodeToFind)
	{
		if(t_startNode.getNodeName().equals(t_nodeToFind.getNodeName()))
		{
			return t_startNode;
		}
		else//search its childnodes
		{
			//check whether it has child nodes
			
			if(t_startNode.hasChilds())//if childnodes present
			{
				Set<LabelNode> childNodes=t_startNode.getChildNodes();
				Iterator<LabelNode> itr=childNodes.iterator();
				LabelNode tempNode=null;
				
				//start searching in each childnodes also
				while(itr.hasNext())
				{
					tempNode=searchNode(itr.next(),t_nodeToFind);
					if(tempNode!=null)
					{
						//the required node is found,so return it and end the search
						return tempNode;
					}
				}
			}
/*			else
			{
				System.out.println("	*Reached end of node["+t_startNode.getNodeName()+"].Node["+t_nodeToFind.getNodeName()+"] not found");
				return null;
			}*/

			//if nothing is found in childnode also,then return null
			return null;
		}//else
		

	}//func
}
