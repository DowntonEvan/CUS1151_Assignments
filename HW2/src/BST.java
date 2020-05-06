/**
 * @author
 *
 */
class BST{
    
    Node root;
    Node found; //Found stores the node found by contains class, this is used for updating nodes after finding them

    private class Node{
    	
    	String keyword;
        Record record;
        int size;
        Node l;
        Node r;

        private Node(String k){ /**Done*/
        	// TODO Instantialize a new Node with keyword k.
            keyword = k;
        }

        private void update(Record r){ /**Done*/
        	//TODO Adds the Record r to the linked list of records. 
        	// You do not have to check if the record is already in the list.
        	//HINT: Add the Record r to the front of your linked list.
            r.next = record;
            record = r;
        }
    }

    public BST(){
        this.root = null;
        this.found = null;
    }
      
    public void insert(String keyword, FileData fd){ /**Done -Untested- */
        Record recordToAdd = new Record(fd.id, fd.title, fd.author, null);
        //TODO Write a recursive insertion that adds recordToAdd 
        // to the list of records for the node associated with keyword.
        // If there is no node, this code should add the node.
        if(root == null){ //First we see if the BST is empty, if it is we occupy the root (the first node) with the new node and its record
            root = new Node(keyword);
            root.update(recordToAdd);
            return;
        }
        if(contains(keyword)){ //If the tree isn't empty we can check to see if the keyword already exists, if so all we need to do is update that node
            found.update(recordToAdd);
            return;
        }
        //If made to this point we need to add the new Node somewhere specific on the tree
        Node theRoot = root; //original root is stored in theRoot and root is restored to the root value at the end of execution
        if(root.keyword.compareTo(keyword) > 0){ //checks to the left if the keyword is alphabetically less than the root keyword
            if(root.l == null){ //If we have found the space for the new Node we create the new node in the appropriate spot, and update its record
                root.l = new Node (keyword);
                root.l.update(recordToAdd);
                root = theRoot; //we then restore the root to its original value and leave the function
            }
            else{
                root = root.l;
                insert(keyword, fd);
            }
        }
        else{ //We can use else here instead of else if (root.keyword.compareTo(keyword) < 0) because that comparison will not equal 0 and it being less than 0 is the only other option
            if(root.r == null){
                root.r = new Node(keyword);
                root.r.update(recordToAdd);
                root = theRoot;
            }
            else{
                root = root.r;
                insert(keyword, fd);
            }
        }
    }
	
    public boolean contains(String keyword){ /**Done -Untested- */
    	//TODO Write a recursive function which returns true
    	// if a particular keyword exists in the BST
        /**
         * Function here works by storing the original root as theRoot and changing the root every time a recursive call is made
         * root is then searched to see if it has the desired keyword. if not we first got to the left of root and repeat until we can no longer go left
         * If in the left nothing was found we begin moving back through the recursion checking the right of every node checked so far
         * all those right nodes are then checked left and right again as you do in a binary search tree until all nodes are checked
         * if the keyword is not found, false is returned at the end of the function.
         */
        Node theRoot = root; //Preserves the original root which allows us to set a new "root" for recursive searching
        if(root.keyword.equals(keyword)){//first see if current root has desired keyword, doing this first save runtime
            found = root; //We want to store the found node so we can edit it's records if need be
            root = theRoot; //returns the root of this tree to the actual root
            return true;
        }
        while(root.l != null){ //Search every node left of root
            root = root.l;
            if(contains(keyword)){
                found = root;
                root = theRoot;
                return true;
            }
        }
        while(root.r != null){ //search every node right of root
            root = root.r;
            if(contains(keyword)){
                found = root;
                root = theRoot;
                return true;
            }
        }
        root = theRoot;
        return false; //If at this point in execution the keyword was not found it is not present, false is returned
    }

    public Record get_records(String keyword){// Done: tested
        //TODO Returns the first record for a particular keyword. 
    	// This record will link to other records
    	// If the keyword is not in the BST, it should return null.
    	Node  n = root;
    	Record re = new Record(0, "record not found", "", null);//dummy record for not found
    	while(n != null)// if the current node is null than we should not continue with the search
    	{
    		
    		if(n.keyword.equals(keyword))
    		{
    			return n.record;
    		}
    		if(n.r == null && n.l == null)//if left and right are both null and our current node is not equal to the keyword than its not in the BST
    		{
    			return re;//can't return null because the Records.print causes a crash if its equal to null
    		}
    			
	    	if(keyword.compareTo(n.r.keyword) > 0)
	    	{
	    	n = n.r;
	    	}
	    	else
	   		{
	   		n = n.l;
	   		}
    	}
    	
    	
    	return re;
    	
    	
    }
    
    public void delete(String keyword){ /**Still working on it- Daniel **/
    	//TODO Write a recursive function which removes the Node with keyword 
    	// from the binary search tree.
    	// You may not use lazy deletion and if the keyword is not in the BST, 
    	// the function should do nothing.
        if(root == null){ //If the BST is empty, returns a negative
            return false;
        }
        //Needs to account for where the node is being deleted. WIP
        if(contains(keyword)){ //If the tree isn't empty we can check to see if the keyword already exists, if so we need to delete that node and transfer the node up
            root = root.l;
            return;
        }
    	
    	
    }

    public void print(){
        print(root);
    }

    private void print(Node t){
        if (t != null)
        {
            print(t.l);
            System.out.println(t.keyword);
            Record r = t.record;
            while(r != null){
            	System.out.println("\t" + r.title);
                r = r.next;
            }
            print(t.r);
        } 
    }
}
