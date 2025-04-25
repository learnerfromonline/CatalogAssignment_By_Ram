const fs = require('fs'); 

function decodeBase(value, base) {
    return parseInt(value, base);
}

function lagrangeBasis(x, i, points) {
    let result = 1;
    for (let j = 0; j < points.length; j++) {
        if (i !== j) {
            result *= (x - points[j].x) / (points[i].x - points[j].x);
        }
    }
    return result;
}


function lagrangeInterpolation(points, x) {
    let result = 0;
    for (let i = 0; i < points.length; i++) {
        result += points[i].y * lagrangeBasis(x, i, points);
    }
    return result;
}

function findConstantTerm(points) {
    return lagrangeInterpolation(points, 0); 
}


function processTestCase(testCase) {
    const points = [];
    
   
    Object.keys(testCase).forEach(key => {
        if (key !== "keys") {
            const point = testCase[key];
            const x = parseInt(key);  
            const y = decodeBase(point.value, parseInt(point.base));  
            points.push({ x, y });
        }
    });

   
    return findConstantTerm(points);
}


function readInputFile(filePath) {
    try {
        const data = fs.readFileSync(filePath, 'utf8'); 
        const testCase = JSON.parse(data); 
        return testCase;
    } catch (err) {
        console.error("Error reading the file:", err);
        return null;
    }
}


function main() {
    
    const testCase1 = readInputFile('./input1.json');
    const testCase2 = readInputFile('./input2.json');

    
    if (testCase1 && testCase2) {
        const result1 = processTestCase(testCase1);
        const result2 = processTestCase(testCase2);

        console.log(`Constant term for first test case: ${result1}`);
        console.log(`Constant term for second test case: ${result2}`);
    } else {
        console.log("Error reading one or both test case files.");
    }
}


main();
