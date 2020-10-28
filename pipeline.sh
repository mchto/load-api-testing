echo 'JENKINS SIMULATION'

echo 'newman test'

node --version
cd api/newman
newman run ExamenManuelChinchilla.postman_collection.json -e envExamManuelChinchilla.postman_environment.json
cd ../../

echo 'load test'

cd load
jmeter -n -t examen_test_plan.jmx
cd ../




