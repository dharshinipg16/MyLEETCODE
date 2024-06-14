/**
 * @param {string} word
 * @return {number}
 */
var minimumPushes = function(word) {
    let n= word.length,keyPress=0,f=1
    while(n!==0){
        
        if(n<=8){
            return keyPress+(n*f)
        }

        n-=8
        keyPress+=8*f
        f++
        
    }
};