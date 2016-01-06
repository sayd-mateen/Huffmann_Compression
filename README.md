# Huffmann_Compression

The program does the following:
-Read in the text to be compressed from the keyboard. Assume it does not contain white space characters and any non-alphabetic characters.
-Calculate the frequency of each character and print out the frequency table as shown in the Introduction.
-Then create the tree using the method explained below.
-Print the encoding table for the characters as shown above, using non-recursive post-order tree traversal.
-Compression: according to the encoding table, print out the compressed form of the input text.
-Decompression: expand, using the Huffmann tree created in step 3, the compressed form of the text you computed in the previous step (don’t use the encoding table for decompression). The output should be the same as the original input text.

Encoding Table:
If we traverse the tree from the root to each leaf node, we will get the encoding for each character. Now the code for each character will be:
E – 0
W- 10
D – 110
S - 111

Example:
Using the Encoding table the text “SEEWEEDDEW” would be encoded as: “111001000110110010”
This takes only 18 bits as compared to 80 bits of the uncompressed text.
