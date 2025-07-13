class Solution {
public:
   
    string answerString(string word, int numFriends) {
        if(numFriends == 1) return word;
        int n = word.size();
        int size = n - numFriends + 1 ;
        string s;
        string largest = "";
         for(int i = 0 ; i < n ; i++)
        {
            s = word.substr(i,size);
            largest = max(largest,s);
        }
        return largest;
    }
};