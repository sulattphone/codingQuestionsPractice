# LeetCode No.409
# From LeetCode Saturday Meetup

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        # Main idea: Add all even-lengthed characters
        # Find largest odd-lengthed char, and add that
        # Add all odd-lengthed characters but with count - 1 to make them all even and as large as possible
        
        
        #keep length of palidrome var
        #keep longest odd length
        #keep longest odd character
        #keep dictionary
        
        #iterate through the string
            #put character and count in dictionary
            
        #iterate through the dictionary
            #if even count, add to length of palindrome
            
            #if odd count, 
                #compare with longest odd length, and assign if bigger - also assign longest odd char
                
        #iterate through the dictionary again
            #if odd:
                #add to dictionary, count - 1
            
        
        palindrome_length = 0
        longest_odd_length = 0
        longest_odd_char = None
        dict = {}
        
        for c in s:
            dict[c] = dict.get(c, 0) + 1
            
        for c, count in dict.items():
            if count % 2 == 0:
                palindrome_length = palindrome_length + count
            else:
                if count > longest_odd_length:
                    longest_odd_length = count
                    longest_odd_char = c
        
        palindrome_length = palindrome_length + longest_odd_length
        if longest_odd_char != None:
            dict.pop(longest_odd_char)
        
        for c, count in dict.items():
            if count % 2 != 0:
                palindrome_length = palindrome_length + (count - 1)
        
        
        return palindrome_length