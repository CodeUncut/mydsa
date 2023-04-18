// Job Sequencing Problem

/*
Given a set of N jobs where each jobi has a deadline and profit associated with it. Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit if and only if the job is completed by its deadline. The task is to find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.
Example 1:

Input:
N = 4
Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
Output:
2 60
Explanation:
Job1 and Job3 can be done with
maximum profit of 60 (20+40).
Example 2:

Input:
N = 5
Jobs = {(1,2,100),(2,1,19),(3,2,27),
        (4,1,25),(5,1,15)}
Output:
2 127
Explanation:
2 jobs can be done with
maximum profit of 127 (100+27).
*/


//Answer in Cpp:

class Solution 
{
    public:
    static bool func(Job &a,Job &b){
        return a.dead<b.dead;
    }
    //Function to find the maximum profit and the number of jobs done.
    vector<int> JobScheduling(Job arr[], int n) 
    { 
        // your code here
        int c = 0, totalprofit=0;
        sort(arr,arr+n,func);
        priority_queue<int,vector<int>,greater<int>> pq;
        for(int i=0;i<n;i++){
            if(arr[i].dead>pq.size())pq.push(arr[i].profit);
            else if(arr[i].dead==pq.size()){
                if(arr[i].profit>pq.top()){
                    pq.pop();
                    pq.push(arr[i].profit);
                }
            }
        }
        c=pq.size();
        while(pq.size()){
            totalprofit+=pq.top();
            pq.pop();
        }
        return {c,totalprofit};
    } 
};