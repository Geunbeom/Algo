function solution(k, dungeons) {
    let max = 0;
    const l = dungeons.length;
    dfs(0, k, []);
    function dfs(t, tired, arr) {
        if (t === l || tired == 0) {
            max = Math.max(max, t);
            return;
        }
        for (let i=0; i<l; i++) {
            if (!arr.includes(i) && tired >= dungeons[i][0]) {
                if (k >= dungeons[i][0]) {
                    arr.push(i);
                    dfs(t+1, tired-dungeons[i][1], arr);
                    arr.pop();
                }
            }
        }
        max = Math.max(max, t);
    }
    
    return max;
}