class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<pair<int,int>,int>>q;
        int m = grid.size();
        int n = grid[0].size();
        int fresh = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 2){
                    q.push({{i,j},0});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int latest = 0;
        while(!q.empty()){
            auto rotts = q.size();
            while(rotts--){
                auto recentRott = q.front();
                pair<int,int>rottPos = recentRott.first;
                latest = max(latest,recentRott.second);
                int i = rottPos.first;
                int j = rottPos.second;
                if(i < m && j+1 < n) {
                    if(grid[i][j+1] == 1){
                        fresh--;
                        q.push({{i,j+1},recentRott.second+1});
                        grid[i][j+1] = 2;
                    }
                }
                if(i+1 < m && j < n) {
                    if(grid[i+1][j] == 1){
                        fresh--;
                        q.push({{i+1,j},recentRott.second+1});
                        grid[i+1][j] = 2;
                    }
                }
                if(i < m && j-1 >= 0) {
                    if(grid[i][j-1] == 1){
                        fresh--;
                        q.push({{i,j-1},recentRott.second+1});
                        grid[i][j-1] = 2;
                    }
                }
                if(i-1 >= 0 && j < n) {
                    if(grid[i-1][j] == 1){
                        fresh--;
                        q.push({{i-1,j},recentRott.second+1});
                        grid[i-1][j] = 2;
                    }
                }
                q.pop();
            }
        }
        if(fresh > 0) return -1;
        return latest;
    }
};