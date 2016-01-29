import java.util.List;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should ignore the word's case.
	 * That is, you should convert the string to all lower case as you insert it. */
	public boolean addWord(String word)
	{
		if(word.isEmpty()) return false;
		if(word == null) throw new NullPointerException("The String variable can't be a null object");

		String temp = word.toLowerCase();
		if(isWord(temp)) return false;
		else
		{
			//char tmp[] = temp.toCharArray();
			//root.insert(tmp[0]);
			root.insert(temp.charAt(0));

			TrieNode node;
			//TrieNode child = root.getChild(tmp[0]);
			TrieNode child = root.getChild(temp.charAt(0));
			if(child == null) throw new NullPointerException("The child from the root can't be null");

			for(int it = 1; it != temp.length()/*tmp.length*/; ++it)
			{
				node = child.getChild(temp.charAt(it));//child.getChild(tmp[it]);
				if(node == null)
				{
					child.insert(temp.charAt(it)/*tmp[it]*/);
					child.setEndsWord(false);

					child = child.getChild(temp.charAt(it)/*tmp[it]*/);
				}
				else child = node;
			}

			child.setEndsWord(true);
			++size;
		}

	    return true;
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size() { return size; }
	
	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) 
	{
		if(IsEmpty() || s.isEmpty()) return false;
		else
		{
			String temp = s.toLowerCase();
			//char tmp[] = temp.toCharArray();

			TrieNode node;
			TrieNode child = root.getChild(temp.charAt(0)/*tmp[0]*/);
			if(child == null) return false;

			for(int it = 1; it != temp.length()/*tmp.length*/; ++it)
			{
				node = child.getChild(temp.charAt(it)/*tmp[it]*/);
				if(node == null)
				{
					if(child.endsWord()) return temp.equals(child.getText());
					else				 return false;

				}
				else child = node;
			}

			if(!child.endsWord()) return false;
			else return temp.equals(child.getText());
		}
	}

	public boolean IsEmpty() { return size() == 0; }

	/** 
	 *  * Returns up to the n "best" predictions, including the word itself,
     * in terms of length
     * If this string is not in the trie, it returns null.
     * @param prefix The text to use at the word stem
     * @param numCompletions The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 
         return null;
     }

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	

	
}