public class ttApp
{
    public static void
    main(String argv[])
    {
        try
        {

            AutoCompleteDictionaryTrie trie = new AutoCompleteDictionaryTrie();
            String word = "Now";
            trie.addWord(word);
            trie.addWord("no");
            trie.addWord("no\'s");
            trie.addWord("nobility");
            trie.addWord("Hello");
            trie.addWord("Madam");
            trie.addWord("Madame");

            word = "nobility";
            boolean has_word = trie.isWord(word);
            System.out.printf("Found \"%s\": %s%n",word, has_word);
            word = "no";
            has_word = trie.isWord(word);
            System.out.printf("Found \"%s\": %s%n",word, has_word);
            word = "now";
            has_word = trie.isWord(word);
            System.out.printf("Found \"%s\": %s%n",word, has_word);
            word = "madaMe";
            has_word = trie.isWord(word);
            System.out.printf("Found \"%s\": %s%n",word, has_word);

            System.out.println("Size of dictionary: " + trie.size());

            trie.printTree();

        }
        catch(Exception ex)
        {
            System.err.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
