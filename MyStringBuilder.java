//Solomon Astley, PeopleSoft #3938540
//CS 0445 Ramirez, Recitation Tuesday 10:00
//This program is a MyStringBuilder class and it is a linked list implementation of
//the StringBuilder class, which is normally implemented with an ArrayList

// CS 0445 Spring 2016
// Read this class and its comments very carefully to make sure you implement
// the class properly.  Note the items that are required and that cannot be
// altered!  Generally speaking you will implement your MyStringBuilder using
// a singly linked list of nodes.  See more comments below on the specific
// requirements for the class.

// For more details on the general functionality of most of these methods, 
// see the specifications of the similar method in the StringBuilder class.  
public class MyStringBuilder
{
	// These are the only three instance variables you are allowed to have.
	// See details of CNode class below.  In other words, you MAY NOT add
	// any additional instance variables to this class.  However, you may
	// use any method variables that you need within individual methods.
	// But remember that you may NOT use any variables of any other
	// linked list class or of the predefined StringBuilder or 
	// or StringBuffer class in any place in your code.  You may only use the
	// String class where it is an argument or return type in a method.
	private CNode firstC;	// reference to front of list.  This reference is necessary
							// to keep track of the list
	private CNode lastC; 	// reference to last node of list.  This reference is
							// necessary to improve the efficiency of the append()
							// method
	private int length;  	// number of characters in the list

	// You may also add any additional private methods that you need to
	// help with your implementation of the public methods.

	// Create a new MyStringBuilder initialized with the chars in String s
	public MyStringBuilder(String s)
	{
		//If the string passed is an empty string or a null pointer, initialize to null and zero length
		if (s == null || s.length() == 0)
		{
			firstC = null;
			lastC = null;
			length = 0;
		}
		else
		{
			//Assign firstC to first character and then traverse through the string, adding one character at a time
			firstC = new CNode(s.charAt(0));
			lastC = firstC;
			for (int i = 1; i < s.length(); i++)
			{
				lastC.next = new CNode(s.charAt(i));
				lastC = lastC.next;
			}
			length += s.length();
		}
	}

	// Create a new MyStringBuilder initialized with the chars in array s
	public MyStringBuilder(char [] s)
	{
		//If the string passed is an empty string or a null pointer, initialize to null and zero length
		if (s.length == 0 || s == null)
		{
			firstC = null;
			lastC = null;
			length = 0;
		}
		else
		{
			//Assign firstC to first character and then traverse through the string, adding one character at a time
			firstC = new CNode(s[0]);
			lastC = firstC;
			for (int i = 1; i < s.length; i++)
			{
				lastC.next = new CNode(s[i]);
				lastC = lastC.next;
			}
			length += s.length;
		}
	}

	// Create a new empty MyStringBuilder
	public MyStringBuilder()
	{
		//Initialize everything to null or zero for empty MyStringBuilder
		firstC = null;
		lastC = null;
		length = 0;
	}

	// Append MyStringBuilder b to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(MyStringBuilder b)
	{
		//Normal case, MyStringBuilder is not empty
		if (length > 0)
		{
			//If passed argument is an empty MyStringBuilder, return current MyStringBuilder
			if (b.length() == 0)
			{
				return this;
			}
			//Otherwise, traverse through passed MyStringBuilder, adding one char at a time using chatAt() method
			else
			{
				for (int i = 0; i < b.length(); i++)
				{
					lastC.next = new CNode(b.charAt(i));
					lastC = lastC.next;
				}
			}
			length += b.length(); //Increment the length
			return this;
		}
		//Special case, length of current MyStringBuilder is zero
		else
		{
			if (b.length() == 0)
			{
				return this;
			}
			else
			{
				//Code here is slightly different than above because the firstC node changes as well as the lastC node
				firstC = new CNode(b.charAt(0));
				lastC = firstC;
				for (int i = 1; i < b.length(); i++)
				{
					lastC.next = new CNode(b.charAt(i));
					lastC = lastC.next;
				}
				length += b.length(); //Increment the length
				return this;
			}
		}
	}


	// Append String s to the end of the current MyStringBuilder, and return
	// the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(String s)
	{
		//Normal case, MyStringBuilder is not empty
		if (length > 0)
		{
			//If passed argument is an empty String, return current MyStringBuilder
			if (s.length() == 0)
			{
				return this;
			}
			else
			{
				//Otherwise, traverse through passed String, adding one char at a time using chatAt() method
				for (int i = 0; i < s.length(); i++)
				{
					lastC.next = new CNode(s.charAt(i));
					lastC = lastC.next;
				}
			}
			length += s.length();
			return this;
		}
		//Special case, length of current MyStringBuilder is zero
		else
		{
			if (s.length() == 0)
			{
				return this;
			}
			else
			{
				//Code here is slightly different than above because the firstC node changes as well as the lastC node
				firstC = new CNode(s.charAt(0));
				lastC = firstC;
				for (int i = 1; i < s.length(); i++)
				{
					lastC.next = new CNode(s.charAt(i));
					lastC = lastC.next;
				}
				length += s.length();
				return this;
			}
		}
	}

	// Append char array c to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(char [] c)
	{
		//Normal case, MyStringBuilder length is greater than zero
		if (length > 0)
		{
			if (c.length == 0)
			{
				return this;
			}
			else
			{
				//Simply traverse through the char array and add one character at a time to the end of the MyStringBuilder
				for (int i = 0; i < c.length; i++)
				{
					lastC.next = new CNode(c[i]);
					lastC = lastC.next;
				}
			}
			length += c.length;
			return this;
		}
		//Special case where length of current MyStringBuilder is equal to zero
		else
		{
			if (c.length == 0)
			{
				return this;
			}
			else
			{
				//Code here is slightly different than above because the firstC must be changed as well as the lastC node
				firstC = new CNode(c[0]);
				lastC = firstC;
				for (int i = 1; i < c.length; i++)
				{
					lastC.next = new CNode(c[i]);
					lastC = lastC.next;
				}
				length += c.length;
				return this;
			}
		}
	}

	// Append char c to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(char c)
	{
		//Special case where the length of the current MyStringBuilder is zero
		if (length == 0)
		{
			//firstC must be assigned and, in this special case, lastC is the same
			firstC = new CNode(c);
			lastC = firstC;
			length++;
			return this;
		}
		//Normal case, just add a new node to the end of the MyStringBuilder
		else
		{
			lastC.next = new CNode(c);
			lastC = lastC.next;
			length++;
			return this;
		}
	}

	// Return the character at location "index" in the current MyStringBuilder.
	// If index is invalid, throw an IndexOutOfBoundsException.
	public char charAt(int index)
	{
		//Normal case, valid index is passe
		if (index < length && index >= 0)
		{
			//traverse through the MyStringBuilder until the index is reached, then return the data at that node
			CNode currNode = firstC;
			for (int i = 0; i < index; i++)
			{
				currNode = currNode.next;
			}
			return currNode.data;
		}
		//Special case, invalid index is given, throw IndexOutOfBoundsException()
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}

	// Delete the characters from index "start" to index "end" - 1 in the
	// current MyStringBuilder, and return the current MyStringBuilder.
	// If "start" is invalid or "end" <= "start" do nothing (just return the
	// MyStringBuilder as is).  If "end" is past the end of the MyStringBuilder, 
	// only remove up until the end of the MyStringBuilder. Be careful for 
	// special cases!
	public MyStringBuilder delete(int start, int end)
	{
		//Special case, invalid start and end parameters are given, so current MyStringBuilder is returned
		if (start < 0 || start >= length || end <= start)
		{
			return this;
		}
		//If passed end parameter is greater than the current length, it is changed to be the current length
		if (end > length)
		{
			end = length;
		}

		if (end == length)
		{
			CNode currNode = firstC;
			for (int i = 0; i < start - 1; i++)
			{
				currNode = currNode.next;
			}
			currNode.next = null;
			lastC = currNode;
			length = length - (end - start);
			return this;
		}
		//Normal case, passed start parameter is a valid index
		else if (start > 0)
		{
			//create two temp nodes to traverse through the MyStringBuilder with
			CNode currNode1 = firstC;
			CNode currNode2 = firstC;

			//traverse through the MyStringBuilder to start index, changing both of the temp nodes each time
			for (int i = 0; i < start - 1; i++)
			{
				currNode1 = currNode1.next;
				currNode2 = currNode2.next;
			}

			//traverse through the MyStringBuilder to end index, only changing the second temp node this time
			for (int i = start; i <= end; i++)
			{
				currNode2 = currNode2.next;
			}

			//connect the two temp nodes together, effectively deleting the nodes between them
			currNode1.next = currNode2;

			//If the last node was changed, make lastC the last node
			//if (end == length)
			//	lastC = currNode2;

			//increment length and return MyStringBuilder
			length = length - (end - start);
			return this;
		}

		//Special case, start node is also the first node, so firstC node must be changed
		else
		{
			CNode currNode = firstC;
			for (int i = start; i < end; i++)
			{
				currNode = currNode.next;
			}

			//After traversing through the array, assign firstC to currNode, effectively deleting the nodes just traversed
			firstC = currNode;
			length = length - end;
			return this;
		}
	}

	// Delete the character at location "index" from the current
	// MyStringBuilder and return the current MyStringBuilder.  If "index" is
	// invalid, do nothing (just return the MyStringBuilder as is).
	// Be careful for special cases!
	public MyStringBuilder deleteCharAt(int index)
	{
		//Special case, invalid index is passed, so MyStringBuilder is returned
		if (index < 0 || index >= length)
		{
			return this;
		}
		//Valid index is passed
		else
		{
			//Special case, index is 0
			if (index == 0)
			{
				firstC = firstC.next;
				length -= 1;
				return this;
			}
			else
			{
				CNode currNode = firstC;
				for (int i = 0; i < index - 1; i++)
				{
					currNode = currNode.next;
				}
				currNode.next = currNode.next.next;

				//Special case, index is at end of MyStringBuilder
				if (index == length - 1)
					lastC = currNode;

				//Decrement the length and return MyStringBuilder
				length -= 1;
				return this;
			}
		}
	}

	// Find and return the index within the current MyStringBuilder where
	// String str first matches a sequence of characters within the current
	// MyStringBuilder.  If str does not match any sequence of characters
	// within the current MyStringBuilder, return -1.  Think carefully about
	// what you need to do for this method before implementing it.
	public int indexOf(String str)
	{
		//Make two currNodes for traversal
		CNode currNode = firstC;
		CNode currNode2 = firstC;
		int index = 0;
		boolean found = false;

		//While loop that only ends when String is found or end of MyStringBuilder is reached
		while (true)
		{
			//If index has reached end of the MyStringBuilder
			if (index == length - 1)
				break;
			//If the char in MyStringBuilder at currNode is equal to first char of passed String
			if (str.charAt(0) == currNode.data)
			{
				//set found to true, then loop throughg the rest of the word, changing found to false if there is a difference
				found = true;
				for (int i = 0; i < str.length(); i++)
				{
					//check if currNode is null first becaue methods will not work on null pointer
					if (currNode == null)
					{
						found = false;
						break;
					}
					if (str.charAt(i) != currNode.data)
					{
						found = false;
						break;
					}
					currNode = currNode.next;
				}
				//if the String was found, return the index it was found at
				if (found)
				{
					return index;
				}
				//currNode needs to be reset to where it was before it was traversed forward in the for loop
				else
					currNode = currNode2;
			}
			//increment both currNodes
			currNode = currNode.next;
			currNode2 = currNode2.next;
			//increment the index
			index++;
		}
		//if the String was never found, return -1
		return -1;
	}

	// Insert String str into the current MyStringBuilder starting at index
	// "offset" and return the current MyStringBuilder.  if "offset" == 
	// length, this is the same as append.  If "offset" is invalid
	// do nothing.
	public MyStringBuilder insert(int offset, String str)
	{
		//if the offset is the length of the MyStringBuilder, the passed String simply needs appended
		if (offset == length)
		{
			this.append(str);
			return this;
		}
		//Special case where the offset is an invalid index
		else if (offset < 0 || offset > length)
			return this;
		//Special case where the offset is 0, the firstC node is going to change
		else if (offset == 0)
		{
			CNode tempNode = firstC;	
			firstC = new CNode(str.charAt(0));
			CNode currNode = firstC;
			for (int i = 1; i < str.length(); i++)
			{
				currNode.next = new CNode(str.charAt(i));
				currNode = currNode.next;
			}
			currNode.next = tempNode;
			length += str.length();
			return this;
		}
		//Normal case in which the offset is valid and not the first or last indices
		else
		{
			CNode currNode = firstC;
			for (int i = 0; i < offset - 1; i++)
			{
				currNode = currNode.next;
			}
			CNode tempNode = currNode.next;
			for (int i = 0; i < str.length(); i++)
			{
				currNode.next = new CNode(str.charAt(i));
				currNode = currNode.next;
			}
			currNode.next = tempNode;
			length += str.length();
			return this;
		}
	}

	// Insert character c into the current MyStringBuilder at index
	// "offset" and return the current MyStringBuilder.  If "offset" ==
	// length, this is the same as append.  If "offset" is invalid, 
	// do nothing.
	public MyStringBuilder insert(int offset, char c)
	{
		//Normal case in which the offset is a valid index and not the first or last indices
		if (offset > 0 && offset < length)
		{
			CNode currNode = firstC;
			for (int i = 0; i < offset - 1; i++)
			{
				currNode = currNode.next;
			}
			CNode tempNode = currNode.next;
			currNode.next = new CNode(c, tempNode);
			length++;
			return this;
		}
		//Special case in which the offset is equal to lenght, the char simply needs to be appended
		else if (offset == length)
		{
			this.append(c);
			return this;
		}
		//Special case in which the offset is zero, the firstC node must be changed
		else if (offset == 0)
		{
			CNode tempNode = firstC;
			firstC = new CNode(c);
			firstC.next = tempNode;
			length++;
			return this;
		}
		//In all other cases (invalid indices), simply return the current MyStringBuilder
		else
		{
			return this;
		}
	}

	// Insert char array c into the current MyStringBuilder starting at index
	// index "offset" and return the current MyStringBuilder.  If "offset" is
	// invalid, do nothing.
	public MyStringBuilder insert(int offset, char [] c)
	{
		//Special case in which the offset is equal to the length, it just needs appended
		if (offset == length)
		{
			this.append(c);
			return this;
		}
		//Case in which an invalid index is passed for the offset, the current MyStringBuilder is returned
		else if (offset < 0 || offset > length)
			return this;
		//Special case in which the offset is zero, the firstC node needs to be changed
		else if (offset == 0)
		{
			CNode tempNode = firstC;
			firstC = new CNode(c[0]);
			CNode currNode = firstC;
			for (int i = 1; i < c.length; i++)
			{
				currNode.next = new CNode(c[i]);
				currNode = currNode.next;
			}
			currNode.next = tempNode;
			length += c.length;
			return this;
		}
		//Normal case, simply traverse through, add in the array of chars, and then connect the end to the next node
		else
		{
			CNode currNode = firstC;
			for (int i = 0; i < offset - 1; i++)
			{
				currNode = currNode.next;
			}
			CNode tempNode = currNode.next;
			for (int i = 0; i < c.length; i++)
			{
				currNode.next = new CNode(c[i]);
				currNode = currNode.next;
			}
			currNode.next = tempNode;
			length += c.length;
			return this;
		}
	}

	// Return the length of the current MyStringBuilder
	public int length()
	{
		return length;
	}


	// Delete the substring from "start" to "end" - 1 in the current
	// MyStringBuilder, then insert String "str" into the current
	// MyStringBuilder starting at index "start", then return the current
	// MyStringBuilder.  If "start" is invalid or "end" <= "start", do nothing.
	// If "end" is past the end of the MyStringBuilder, only delete until the
	// end of the MyStringBuilder, then insert.
	public MyStringBuilder replace(int start, int end, String str)
	{
		//Special case in which the passed parameters are invalid, simply return the current MyStringBuilder
		if (start >= length || end <= start)
		{
			return this;
		}
		//If end is greater than length, change to be equal to length
		if (end > length)
			end = length;
		//Because of the way the delete and insert methods are implemented, this method can simply call the two
		//respectively in order to replace a String within the MyStringBuilder
		this.delete(start, end);
		this.insert(start, str);
		return this;
	}

	// Return as a String the substring of characters from index "start" to
	// index "end" - 1 within the current MyStringBuilder
	public String substring(int start, int end)
	{
		//Special case in which the start is 0, no pre-traversing of the MyStringBuilder is necessary
		if (start == 0)
		{
			CNode currNode = firstC;
			MyStringBuilder newBuilder = new MyStringBuilder();
			for (int i = 0; i < end; i++)
			{
				newBuilder.append(currNode.data);
				currNode = currNode.next;
			}
			return newBuilder.toString();
		}
		//Normal case with valid indices
		else if (start > 0 && end < length)
		{
			CNode currNode = firstC;
			for (int i = 0; i < start - 1; i++)
			{
				currNode = currNode.next;
			}
			MyStringBuilder newBuilder = new MyStringBuilder();
			for (int i = start; i < end; i++)
			{
				newBuilder.append(currNode.next.data);
				currNode = currNode.next;
			}
			return newBuilder.toString();
		}
		//If invalid indices are given, an IndexOutOfBoundsException() is thrown
		else
			throw new IndexOutOfBoundsException();
	}

	// Return the entire contents of the current MyStringBuilder as a String
	public String toString()
	{
		//First converts the MyStringBuilder to a char array and then converts that to a String and returns it
		char [] charArray = new char [length];
		CNode currNode = firstC;
		for (int i = 0; i < length; i++)
		{
			charArray[i] = currNode.data;
			currNode = currNode.next;
		}
		String b = new String(charArray);
		return b;
	}

	// You must use this inner class exactly as specified below.  Note that
	// since it is an inner class, the MyStringBuilder class MAY access the
	// data and next fields directly.
	private class CNode
	{
		private char data;
		private CNode next;

		public CNode(char c)
		{
			data = c;
			next = null;
		}

		public CNode(char c, CNode n)
		{
			data = c;
			next = n;
		}
	}
}