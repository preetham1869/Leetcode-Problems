class Solution {
public:
    static bool comp(const pair<string,int>&a , const pair<string,int>&b)
    {
        if(a.second == b.second) return a.first < b.first;
        return a.second > b.second;
    } 
    vector<string> topKFrequent(vector<string>& words, int k) {
        map<string,int>frq;
        for(string word : words){
            frq[word]++;
        }
        vector<pair<string,int>>A;
        for(auto it : frq){
            A.push_back({it.first,it.second});
        }
        sort(A.begin(),A.end(),comp);
        vector<string>ans;
        for(int i = 0 ; i < k ; i++)
        {
            ans.push_back(A[i].first);
        }
        return ans;
    }
};