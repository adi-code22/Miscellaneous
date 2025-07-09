# 🚀 Bloom Filter in Java

> "This username is already taken." ❌  
Ever wondered how platforms like Facebook or Google check billions of usernames in real-time and instantly tell you if it's already taken?  
That’s where **Bloom Filters** come in.

This repo contains a simple yet powerful **Bloom Filter** implementation in Java, along with explanations and visual aids to help you understand how it works under the hood.

---

## 📌 What is a Bloom Filter?

A **Bloom Filter** is a space-efficient probabilistic data structure designed to test whether an element is a member of a set. It can quickly tell:
- ✅ **Definitely not present**
- ❓ **Might be present** (with a small false positive rate)

Perfect for:
- Username lookups
- Caches
- Web crawlers (visited URL tracking)
- Network security tools

---

## 💡 How It Works

1. **Start with an empty bit array and multiple hash functions.**
2. **When adding a value:**
   - Hash the value using all hash functions
   - Set those positions in the bit array to 1
3. **When checking a value:**
   - Hash it again and inspect the same bit positions
   - If **any bit is 0** → definitely not there
   - If **all bits are 1** → might be there

---

## 🛠️ Code Overview

- `BloomFilter.java`  
  Java implementation of a basic Bloom Filter using `BitSet` and `MessageDigest`.

### Example

```bash
javac BloomFilter.java
java BloomFilter
```

## 🤔 Why Use a Bloom Filter?

- ⚡ Extremely fast lookups  
- ✅ No false negatives  
- 💾 Very space-efficient  
- 🌐 Scales to billions of records  

---

## 🧠 Concepts Used

- 🔐 Hashing with MD5 (can be swapped for better hash functions)  
- 🧮 Bit manipulation using `BitSet`  
- 🎲 Probabilistic modeling for approximate membership testing  

---

## 📚 Further Reading

- [Wikipedia: Bloom Filter](https://en.wikipedia.org/wiki/Bloom_filter)  
- [MIT: Introduction to Bloom Filters](https://cs.stackexchange.com/questions/7054/what-is-a-bloom-filter)  
- [Scalable Bloom Filters – Google Research](https://research.google/pubs/pub44824/)  

---

## 📌 License

This project is open source under the [MIT License](LICENSE).

---

## 🙌 Author

Built by [ChatGPT](https://chatgpt.com/)

