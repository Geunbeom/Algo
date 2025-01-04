function solution(n, m, section) {
    var answer = 1;
    var curr = section[0];
    for (let i=1; i<section.length; i++) {
        if (section[i] - curr < m) continue;
        answer++;
        curr = section[i];
    }
    
    return answer;
}