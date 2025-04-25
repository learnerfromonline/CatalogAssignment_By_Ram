# 🔐 Catalog Placements Assignment – Shamir's Secret Sharing (Simplified)

This project solves a simplified version of **Shamir's Secret Sharing** scheme. The goal is to determine the **constant term `c`** of a polynomial using given roots (x, y) where the y-values are encoded in various bases and provided in a JSON file.

---

## 📁 Directory Structure

```
CatalogAssignment/
├── gson-2.8.9.jar         # Gson library for JSON parsing
├── Main.java              # Java source code
├── Main.class             # Compiled Java class
├── input1.json            # First test case
├── input2.json            # Second test case
├── README.md              # Project documentation (this file)
```

---

## 🧠 Problem Description

We are given a polynomial of degree `m`. The minimum number of points needed to reconstruct it is `k = m + 1`. The JSON input provides:

- `n` total points
- `k` number of points required to compute the coefficients
- Each point (x, y) where:
  - `x` is the key
  - `y` is a string representing a number in a specified base

The goal is to compute `f(0)`, which gives the **constant term `c`**.

---

## ⚙️ Steps Performed

1. **Read JSON input** files `input1.json` and `input2.json`.
2. **Decode y-values** to decimal using their specified base.
3. **Select the first `k` points** from the JSON file.
4. **Apply Lagrange Interpolation** to compute the constant term `c = f(0)`.
5. **Print the output** for both test cases.

---

## 🧪 Sample Output

```
Secret for input1.json is: 3
Secret for input2.json is: 79836264049764
```

---

## 🚀 How to Run

### ✅ Step 1: Download `gson-2.8.9.jar`

Download from [Maven Central](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.8.9/gson-2.8.9.jar) and place it in your working directory.

---

### ✅ Step 2: Compile

```bash
javac -cp gson-2.8.9.jar Main.java
```

---

### ✅ Step 3: Run

On **Windows** (PowerShell or CMD):
```bash
java -cp ".;gson-2.8.9.jar" Main
```



---

## 📘 Example Input Format

```json
{
  "keys": {
    "n": 4,
    "k": 3
  },
  "1": {
    "base": "10",
    "value": "4"
  },
  "2": {
    "base": "2",
    "value": "111"
  },
  "3": {
    "base": "10",
    "value": "12"
  },
  "6": {
    "base": "4",
    "value": "213"
  }
}
```

---

## 🛠 Technologies Used

- Java
- Gson library for JSON parsing
- BigInteger for arbitrary precision arithmetic
- Lagrange Interpolation for polynomial reconstruction

---


## 👤 Author

Assignment completed by **P Satya Ram Kumar**  
For **Catalog Placements Online Assessment**

---
