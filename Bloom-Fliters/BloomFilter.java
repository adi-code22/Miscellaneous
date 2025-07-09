/*
* AI Generated Code
* @author ChatGPT
*
*/

import java.util.BitSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class BloomFilter {
    private BitSet bitSet;
    private int bitSize;
    private int hashFunctions;

    public BloomFilter(int bitSize, int hashFunctions) {
        this.bitSet = new BitSet(bitSize);
        this.bitSize = bitSize;
        this.hashFunctions = hashFunctions;
    }

    public void add(String value) {
        int[] hashes = getHashes(value);
        for (int hash : hashes) {
            bitSet.set(hash);
        }
    }

    public boolean mightContain(String value) {
        int[] hashes = getHashes(value);
        for (int hash : hashes) {
            if (!bitSet.get(hash)) return false;
        }
        return true;
    }

    private int[] getHashes(String value) {
        int[] hashes = new int[hashFunctions];
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < hashFunctions; i++) {
            hashes[i] = Math.abs(hash(bytes, i)) % bitSize;
        }
        return hashes;
    }

    private int hash(byte[] data, int seed) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update((byte) seed);
            byte[] digest = md.digest(data);
            int hash = 0;
            for (int i = 0; i < 4; i++) {
                hash <<= 8;
                hash |= (digest[i] & 0xFF);
            }
            return hash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 not found", e);
        }
    }

    public static void main(String[] args) {
        BloomFilter bloom = new BloomFilter(1000, 3);

        bloom.add("aditya");
        bloom.add("krishnan");

        System.out.println("Contains aditya? " + bloom.mightContain("aditya"));
        System.out.println("Contains krishnan? " + bloom.mightContain("krishnan"));
        System.out.println("Contains john? " + bloom.mightContain("john")); // likely false
    }
}
