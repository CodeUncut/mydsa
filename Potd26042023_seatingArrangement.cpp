// Seating Arrangement
// In c++

/*
You are given an integer n, denoting the number of people who needs to be seated, and a list of m integers seats, where 0 represents a vacant seat and 1 represents an already occupied seat.

Find whether all n people can find a seat, provided that no two people can sit next to each other.

Example 1:

Input:
n = 2
m = 7
seats[] = {0, 0, 1, 0, 0, 0, 1}
Output:
Yes
Explanation:
The two people can sit at index 0 and 4.
Example 2:

Input:
n = 1
m = 3
seats[] = {0, 1, 0}
Output:
No
Explanation:
There is no way to get a seat for one person.
*/


//Answer:


class Solution{
    public:
    bool is_possible_to_get_seats(int n, int m, vector<int>& seats){
        // Write your code here.
        int count=0;
        
        for(int i=0;i<m;i++)
        {
        if(seats[i]==0){
            if(i==0){
                if(seats[i+1]==0){
                    count++;
                    seats[i]=1;
                }
            }
            else if(i==m-1)
            {
                if(seats[i-1]==0)
                {
                    count++;
                    seats[i]=1;
                }
            }
            else
            {
              if(seats[i-1]==0 && seats[i+1] ==0)
              {
                  count++;
                  seats[i] =1;
              }
            }
        }
        }
        return count>=n;
    }
};