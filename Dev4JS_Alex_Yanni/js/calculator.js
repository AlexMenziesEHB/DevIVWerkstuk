var calcHistory = [];

window.addEventListener('load', function () {
    addEventListenersButtons();
});

function addEventListenersButtons(){
    const elements = document.getElementsByClassName("dropdown-item");

    for (let i = 0; i < elements.length; i++) {
        elements[i].addEventListener("click", handleSearch);
    }
}

function calculate() {
    const operant1 = +document.getElementById("number1")?.value;
    const operant2 = +document.getElementById("number2")?.value;
    const operator = document.getElementById("selectOperator").value;
    const strategy = Factory.get(operator);

    if(strategy){
        const result = strategy.executeStrategy(operant1, operant2);
        document.getElementById("number3").value = result;
        updateCalculationHistoryTable(operant1, operant2, operator, result);
    }
}

function handleSearch(el){
    const clickedEl = el.srcElement.attributes.val.value;
    const iptValue = document.getElementById('searchFieldHistory').value;

    if (!iptValue){
        hideResults();
    }
    else{
        document.getElementById('searchFieldHistory').classList.remove("is-invalid");

        const qry = isNaN(iptValue) ? iptValue : +iptValue;
        const resultIdx = stupidSearch(calcHistory.map(x => x[clickedEl]), qry);
    
        if (resultIdx != -1) {
            okCalcHistoryResult(calcHistory[resultIdx]);
        }
        else {
            failCalcHistoryResult();
        }
    } 
}

class Add {
    //impure function
    calculate(operant1, operant2){
        return operant1 + operant2;
    }
}

class Subtract {
    //impure function
    calculate(operant1, operant2){
        return operant1 - operant2;
    }
}

class Divide {
    //impure function
    calculate(operant1, operant2){
        return operant1 / operant2;
    }
}

class Multiply {
    //impure function
    calculate(operant1, operant2){
        return operant1 * operant2;
    }
}

class Context {
    constructor(context){
        this.context = context;
    }

    //impure function
    executeStrategy(operant1, operant2) {
        return this.context?.calculate(operant1, operant2);
    }
}

class Factory {
    //impure function
    static get(type) {
        if (String(type).toLowerCase() === "+") {
            return new Context(new Add());
        }
        else if (String(type).toLowerCase() === "-") {
            return new Context(new Subtract());
        }
        else if (String(type).toLowerCase() === "/") {
            return new Context(new Divide());
        }
        else if (String(type).toLowerCase() === "*") {
            return new Context(new Multiply());
        }
        else {
            return null;
        }
      }
}

class History {
    constructor(operant1, operant2, operator, result) {
        this.operant1 = operant1;
        this.operant2 = operant2;
        this.operator = operator;
        this.result = result;
    }
}

function updateCalculationHistoryTable(operant1, operant2, operator, result) {
    const tableElement = document.getElementById("calcHistoryRow");
    calcHistory.push(new History(operant1, operant2, operator, result));
    tableElement.style.visibility = "visible";
    tableElement.getElementsByTagName("tbody")[0].innerHTML += fillHTMLHistoryRow(operant1, operant2, operator, result);
}

// impure function
function fillHTMLHistoryRow(operant1, operant2, operator, result){
    return `<tr>
        <td>${operant1}</td>
        <td>${operator}</td>
        <td>${operant2}</td>
        <th>${result}</th>
    </tr>`;
}

function okCalcHistoryResult(result){    
    document.getElementById("failResult").style.display = 'none';
    const successEl = document.getElementById("successResult");

    successEl.innerHTML = `${result.operant1} ${result.operator} ${result.operant2} = ${result.result}`;
    successEl.style.display = 'inline';
}

function failCalcHistoryResult(){    
    document.getElementById("successResult").style.display = 'none';
    document.getElementById("failResult").style.display = 'inline';
}

// side-effect function: just needed to change some DOM properties without returning a value.
function hideResults(){
    document.getElementById('searchFieldHistory').classList.add("is-invalid")
    document.getElementById("successResult").style.display = 'none';
    document.getElementById("failResult").style.display = 'none';
}

// impure function: this function is given an array, in which it searches for a given value. It returns the idx when it finds a match.
function stupidSearch (array, value) {
    let found = false;
    let steps = 0
    for (let i = 0; i < array.length; i++) {
      steps++;
      if (array[i] === value) {
        found = true;
        break;
      }
    }

    return found ? steps - 1 : -1;
};