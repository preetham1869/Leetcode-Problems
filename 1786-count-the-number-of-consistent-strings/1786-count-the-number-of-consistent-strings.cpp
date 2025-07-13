class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        int count=0;
        for(int i = 0 ; i < words.size() ; i++)
        {
            int flag=1;
            for(int j = 0 ; j < words[i].size() ; j++)
            {
                char ch = words[i][j];
                const char* ch1 = strchr(allowed.c_str(), ch);
                if(ch1 == NULL)
                {
                    flag = 0;
                    break;
                }
            }
            if(flag == 1)
            {
                count++;
            }
        }
        return count;
    }
};