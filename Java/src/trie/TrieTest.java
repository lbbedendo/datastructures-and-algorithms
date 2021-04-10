package trie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    @Test
    public void insert_trieNotEmpty_whenInsertingNewElementsToTrie() {
        var trie = createExampleTrie();

        assertFalse(trie.isEmpty());
    }

    @Test
    public void contains_findIfTrieContainsElement_whenSearchingForElementsInAGivenTrie() {
        var trie = createExampleTrie();

        assertFalse(trie.contains("java"));
        assertFalse(trie.contains("vida"));
        assertTrue(trie.contains("life"));
        assertTrue(trie.contains("programming"));
    }

    @Test
    public void remove_removeElementIfFound_whenElementExistsInAGivenTrie() {
        var trie = createExampleTrie();

        assertTrue(trie.contains("programming"));
        trie.remove("programming");
        assertFalse(trie.contains("programming"));
    }

    private Trie createExampleTrie() {
        var trie = new Trie();
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