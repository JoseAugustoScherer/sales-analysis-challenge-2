# Programming Task: Sales Data Processing 2

You must read a .csv file containing a database of sales records and instantiate in memory a list of Sale objects, according to the project design shown alongside (Attention: do not use primitive types int and double for attributes and methods! Use the wrapper types Integer and Double, as shown in the project).

After reading the data, your program should display the total amount sold by each seller, as in the example (the order in which the sellers are shown does not matter).
Attention: your program must scan the entire list to find the names of the sellers.
Attention: if any failure occurs while reading the file, the exception must be handled, and a message should be displayed as in the example.

## Exemple 1
```
Enter the file path: C:\document\path\here

Total sales by seller:
Logan: 220443.05
Rachel Roth: 502478.67
Padme Amidala: 473104.63
Barry Allen: 499946.28
Victor Von Doom: 478657.40
Kal-El: 444881.58
Anakin: 477153.54
Wanda Maximoff: 470741.34
```
## Exemple 2
```
ERROR: C:\document\path\here (The system cannot find the file specified).
```
