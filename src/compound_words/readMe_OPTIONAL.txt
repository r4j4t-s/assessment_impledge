------THIS TEXT FILE IS TO GIVE A LITTLE EXPLAINATION-------

The src folder has module named compound_words.


-Trie.java

Trie.java is the implementation of the data structure trie that was mandatory to make this algorithm work.
The bruteforce method would have been way too slow and hence the need of this data structure.
The program makes use of another java file called Node which defines the blue print of each node that Trie makes.
Trie has two methods- insert() and search(). I did not include other cassical methods like isPrefix() etc 
as there was no actual need to do so.


-Node.java

this class is nothing but the blue prints of the nodes. It has three attributes. 
char c, which is the character stored at that node.
boolean isWord, which tells if that particular node is end of a word.
and Node[] children. which is an array of children nodes associated with that particular node.


-Runner.java

This class makes use of various attributes and methods. The basic idea is to have a TreeMap having the pair
of Integer and ArrayList to store the lists of words with a partiular length and so that we can easily find
thhe words with the greatest lengths.

Inside of the main method,
We read the file and we simply populate the trie with words from the input file and we populate the map as well.
then we simply call the findCompound() method. We also keep the note of start and end time of the program
to print out the difference between the two.

Inside of the findCompound method,
We iterate through the lists stored in the map and keep a counter to print the only first two words.
we Call the isCompound() method, to check for compound words. The method had to be made because the check
for compound was much more simpler in a recursive fashion

Inside of the isCompound method,
the method take argument as the word itself and the boolean b which we can understand as a variable to know if
the word is present as single non compound word inside of the trie.

the base case is we see that is the word present in the trie and is the word a single non compund word. If the 
word exists in trie and is a compoound word that means it is a compund word.
newxt we go ahead and iterate through the entire word and we find all the possible substrings and check if 
the first part exist in the trie and if the second part is a compound word. The logic is that the second part 
is going to be made up of the first part plus some suffix to the first part.
