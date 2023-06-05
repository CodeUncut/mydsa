Problems
Courses
Job-a-ThonMEGA
Contests
POTD


Find the Closest Element in BST
MediumAccuracy: 47.51%Submissions: 65K+Points: 4
Getting a High Paying Job Now Easier Than Today's Problem! Apply For Mega Job-A-Thon  

Given a BST and an integer. Find the least absolute difference between any node value of the BST and the given integer.

Example 1:

Input:
        10
      /   \
     2    11
   /  \ 
  1    5
      /  \
     3    6
      \
       4
K = 13
Output: 
2
Explanation: K=13. The node that has
value nearest to K is 11. so the answer
is 2
Example 2:

Input:
      8
    /   \
   1     9
    \     \
     4    10
    /
   3
K = 9
Output: 
0
Explanation: K=9. The node that has
value nearest to K is 9. so the answer
is 0.
Your Task:
You don't need to read input or print anything. Your task is to complete the function minDiff() that takes the root of the BST and an integer K as its input and returns the minimum absolute difference between any node value of the BST and the integer K.

Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= Number of nodes <= 105
1 <=data<= 105

View Bookmarked Problems 
Company Tags
Topic Tags
Related Courses
Related Interview Experiences
If you are facing any issue on this page. Please let us know.
C++ (g++ 5.4)
Average Time: 30m



        if(root==null) return;


 

Custom Input
