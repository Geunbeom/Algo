function solution(users, emoticons) {
    var answer = [0, 0];
    var cal = new Array(emoticons.length);
    emoticons.forEach((e, l) => {
        cal[l] = new Array(4);
        for (var i=0; i<4; i++) {
            cal[l][i] = Math.round(e*(10-i-1)/10);
        }
    })
    
    var arr = new Array(emoticons.length);
    todo(arr, 0, cal, answer, users);
    
    return answer;
}

function todo(i, j, cal, answer, users) {
    if (j === i.length) {
        var curr = [0, 0];
        
        users.forEach((e) => {
            var sum = 0;
            i.forEach((k, idx) => {
                if (e[0] <= (k+1)*10) {
                    sum += cal[idx][k];
                }
            })
            if (sum >= e[1]) {
                curr[0] += 1;
            }else {
                curr[1] += sum;
            }
        })
        
        if (answer[0] < curr[0]) {
            answer[0] = curr[0];
            answer[1] = curr[1];
        }else if(answer[0] === curr[0] && answer[1] < curr[1]) {
            answer[0] = curr[0];
            answer[1] = curr[1];
        }
        
        return;
    }
    
    for (var l=0; l<4; l++) {
        i[j] = l;
        todo(i, j+1, cal, answer, users);
    }
    
}