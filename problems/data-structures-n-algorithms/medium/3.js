// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    var sLen = s.length;
    var len=0;
    var max = 0;
    var map = {};
    for(var i = 0; i < sLen; i++){
        if(!map.hasOwnProperty(s[i])){
            map[s[i]] = i;
            len++;
        }else{
            if(len > max){
                max = len;
            }
            len = 0;
            i = map[s[i]];
            map = {};


        }
    }

    if(len > max){
        max = len;
    }

    return max;
};