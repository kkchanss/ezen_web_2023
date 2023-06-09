/*
  [ JS 연산자 과제1 ]
   문제11 : 정수 3개를 입력받아 오름차순 으로 출력    [ 7 5 9 -> 5 7 9]
   문제12 : [ 가위바위보 게임 ] 
   - 가위가 '0' 이고 바위가 '1' 이고 보가 '2' 일때 플레이어1와 플레이어2 가 있습니다. 
   - 승리자 판단과 무승부 경우의수를 출력하시오.
   [입력]
      플레이어1가 0 혹은 1 혹은 2 입력받아 변수에 저장합니다.
      플레이어2가 0 혹은 1 혹은 2 입력받아 변수에 저장합니다.
   [경우의수 판단]
      플레이어1 이겼을때 경우의수 ' 플레이어1 승리 ' 출력
      플레이어2 이겼을때 경우의수 ' 플레이어2 승리 ' 출력
      비겼을경우 '무승부' 출력
*/


// 문제11
let num1 = +prompt('정수1 입력');
let num2 = +prompt('정수2 입력');
let num3 = +prompt('정수3 입력');

let max = num1 > num2 ? (num1 > num3 ? num1 : num3) : num2 > num3 ? num2 : num3
let min = num1 < num2 ? (num1 < num3 ? num1 : num3) : num2 < num3 ? num2 : num3
let mid = max != num1 && min != num1 ? num1 : max != num2 && min != num2 ? num2 : num3

alert(min + " " + mid + " " + max)

// 문제12

let p1 = +prompt('0, 1, 2 중 입력');
let p2 = +prompt('0, 1, 2 중 입력');

let answer = p1 == p2 ? '무승부' : (p1+1 == p2 || p2+2 == p1) ? '플레이어2 승리' : '플레이어1 승리'
alert(answer)