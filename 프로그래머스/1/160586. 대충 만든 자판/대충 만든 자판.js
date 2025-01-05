function solution(keymap, targets) {
    var answer = new Array(targets.length);
    var code = new Array(26).fill(20000);
    
    keymap.forEach(e => {
        for(let i=0; i<e.length; i++) {
            var c = e.charAt(i).charCodeAt(0)-65;
            code[c] = Math.min(code[c], i+1);
        }
    })
    
    targets.forEach((e, index) => {
        answer[index] = 0;
        
        for(let i=0; i<e.length; i++) {
            var c = e.charAt(i).charCodeAt(0)-65;
            if (code[c] === 20000) {
                answer[index] = -1;
                break;
            }
            else answer[index] += code[c];
        }
    })
    
    return answer;
}