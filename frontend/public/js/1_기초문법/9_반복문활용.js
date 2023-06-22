

let output = '';

// 문제1) 입력받은 수 만큼 * 출력
let value1 = prompt('문제1 : ')
for(let i = 1; i <= value1; i++) { // i는 1부터 입력받은 수까지 1씩 반복
	output += '*'
}
console.log(output)

// 문제2) 입력받은 수 만큼 * 출력 [  - 3줄(3배수)마다 줄바꿈 ]
output = '';
let value2 = prompt('문제2 : ')
for(let i = 1; i <= value2; i++) {
	output += '*'
	if(i%3==0) output+='\n'
}
console.log(output)
/* 문제3) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
*
**         
***      
****   
*****
*/
output='';
let value3 = prompt('문제3 : ')
for(let i = 1; i <= value3; i++) {
	for(let j = 1; j <= i; j++) {
		output+='*'
	}
	output+='\n'
}
console.log(output)
/* 문제4) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
*****
****
***
**
*
*/
output='';
let value4 = prompt('문제4 : ')
for(let i = value4; i >= 1; i--) {
	for(let j = 1; j <= i; j++) {
		output+="*"
	} 
	output+='\n'
}
console.log(output)
/* 문제5) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
    *
   **
  ***
 ****
*****
*/
output='';
let value5 = prompt('문제5 : ')
for(let i = 1; i <= value5; i++ ) {
	for(let j = value5-i; j >= 1; j--) {
		output+=' '
	}
	for(let k = 1; k <= i; k++) {
		output+='*'
	}
	output+='\n'
}
console.log(output)
/* 문제6) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
*****
 ****
  ***
   **
    *
*/
output='';
let value6 = prompt('문제6 : ')
for(let i = 0; i < value6; i++) {
	for(let k = 0; k < i; k ++){
		output+=' ';
	}
	for(let j = value6-i; j >= 1; j--){
		output+='*';
	}
	output+='\n';
}
console.log(output)

/* 문제7) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
    *
   ***
  *****
 *******
*********
*/
output='';
let value7 = prompt('문제7 : ')
for(let i = 0, y = 1; i < value7; i++, y+=2) {
	for(let j = value7-i; j >= 0; j--) {
		output+=' ';
	}
	for(let k = 1; k <= y; k++) {
		output+='*';
	}
	output+='\n';
}
console.log(output)

/* 문제8) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
*********
 *******
  *****
   ***
    *
*/
output='';
let value8 = prompt('문제8 : ')
for(let i = 0, y = 0; i < value8; i++, y+=2) {
	for(let j = 0; j < i; j++) {
		output+=' ';
	}
	for(let k = y; k < (value8*2-1); k++) {
		output+='*';
	}
	output+='\n';
}
console.log(output)

/* 문제9) 입력받은 줄 수 만큼 * 출력  [ ex) 10 ]
    *
   ***
  *****
 *******
*********
*********
 *******
  *****
   ***
    *
*/
output='';
let value9 = prompt('문제9 : ')
let value9_1 = Math.round(value9/2)
let value9_2 = Math.floor(value9/2)

for(let i = 0, y = 1; i < value9_1; i++, y+=2) {
	for(let j = value9_1-i; j > 0; j--) {
		output+=' ';
	}
	for(let k = 1; k <= y; k++) {
		output+='*';
	}
	output+='\n';
}
for(let i = 0, y = 0; i < value9_2; i++, y+=2) {
	for(let j = 0; j <= i; j++) {
		output+=' ';
	}
	for(let k = y; k < (value9_2*2-1); k++) {
		output+='*';
	}
	output+='\n';
}
console.log(output)

/* 문제10) 입력받은 줄 수 만큼 * 출력  [ ex) 7 ]  4 3 * 3                        5 -- 3 2 
*          * -- 12 10
  *      * -- 8 6
    *  * -- 4 2 
      * -- 1
    *  * -- 4
  *      * -- 2
*          * -- 0 
*/

output = '' 
let value10 = prompt('문제10 : ')
let value10_1 = Math.round(value10/2)
let value10_2 = Math.floor(value10/2)
let value10_3 = value10_2*4-2;
let value10_4;
for(let i = 0, k = 0, y = 0; i < value10_1; i++, k+=4, y+=2) {
	for(let x = 0; x < y; x++) {
		output += ' '
	}
	output+='*'
	for(let j = value10_3-k; j > 0; j--) {
		output+=' '
	}
	if(i != value10_1-1) output+='*';
	else value10_4 = y-2;
	output+='\n'
}

for(let i = 0, k = 0; i < value10_2; i++, k+=4, value10_4-=2) {
	for(let j = 0; j < value10_4; j++) {
		output+=' '
	}
	output+='*'
	for(let x = 0; x < k+2; x++) {
		output += ' '
	}
	output+='*\n'
}
console.log(output)

/*

// 문제10) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
 output = '';
 let line8 = prompt('문제10 :')
    for(let i = 1; i<=line8; i++) {
       for(let b = 1; b<=line8; b++ ) {
         if(i==b || (i+b==line8-1)) {
          output += '*'} else{
             output+= ' '
          } 
       }
    }
*/
