// 2015 => ES6
// ES2016 ES2017 ES2018

// type-safe değil!
/*
var text = "Merhaba, Tobeto";
console.log(text);
text = 123;
console.log(text);

let text2 = "Merhaba, Kodlamaio"; // 2015 es6
*/
/*
var hello = "selam";
console.log(hello);
var hello = "merhaba";

if (true) {
    var deger = 123;
}
console.log(deger);

let hello2 = "merhaba";
console.log(hello2);
//let hello2 = "selam";

if (true) {
    let deger2 = 123;
}
console.log(deger2);
*/

// parametrelerde sadece takma ad
function topla(a, b) {
    console.log(a + b);
}

topla(5, 10);

// constant => tek bir kere tanımlanabilir

// Arrow Function
const toplaFunction = (a, b) => {
    return a + b;
}

const toplaFunction2 = (a, b) => a + b;

let list = [5, 10, 15, 20]
// callback functionlardaki parametreler opsiyoneldir.
list.forEach((element, i, array) => {
    console.log(element, i, array)
});

// 3 parametre => () => {}
// ** map => geriye bir array döner..
let mappedList = list.map((a) => { return a * 2; })
console.log(mappedList);

// süslü parantez => return
// yoksa tek satır
let filteredList = list.filter((a) => { return a > 10 });
console.log(filteredList)

// {}
console.log("*****")
let value = list.reduce((previousValue, currentValue) => {
    console.log(previousValue, currentValue);
    return previousValue + currentValue;
});
console.log(value);

