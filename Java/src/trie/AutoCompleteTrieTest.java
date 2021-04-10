package trie;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AutoCompleteTrieTest {

    @Test
    public void search_threeWords_whenSearchingForPrefix() {
        var autoCompleteTrie= createExampleTrie();

        var wordList = autoCompleteTrie.search("pro");
        assertTrue(Arrays.asList("programming", "product", "professional").containsAll(wordList));
    }

    private AutoCompleteTrie createExampleTrie() {
        var trie = new AutoCompleteTrie();
        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");
        trie.insert("Professional");
        trie.insert("Product");
        return trie;
    }

}