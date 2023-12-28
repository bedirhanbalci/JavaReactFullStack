let i: string = "Merhaba";

let text: string;

function myFunction2(): void {
  console.log("Merhaba");
}

const myFunction = (): number => {
  console.log("Merhaba");

  return 5;
};

myFunction();
myFunction2();

interface MyModel {
  index: number;
  text: string;
}

const myParameterFunc = (myModel: MyModel) => {};

myParameterFunc({ index: 1, text: "Deneme" });
