const getFullNameGreeting = require('../src/main')
const expect = require('chai').expect;

describe('Nuestro primer suite', ()=>{

    it ('Obtener saludo' , () =>{
        const saludo = getFullNameGreeting('pablo','calvo');
        expect(saludo).to.equal('Hello pablo calvo');
    })
});

