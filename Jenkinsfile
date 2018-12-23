podTemplate(
    inheritFrom: "maven", 
    label: "myJenkins", 
    cloud: "openshift", 
    volumes: [
        persistentVolumeClaim(claimName: "m2ssi", mountPath: "/home/jenkins/.m2/")
    ]) {

    node("myJenkins") {

        @Library('github.com/redhat-helloworld-msa/jenkins-library@master') _
        
        stage ('SCM checkout'){
            echo 'Checking out git repository'
            checkout scm
        }
    
        stage ('Maven build'){
            echo 'Building project'
            sh "mvn package"
        }
    
        stage ('DEV - Image build'){
            echo 'Building docker image and deploying to Dev'
    		sh "oc create configmap ssi-config --from-file=application.yml || echo 'Application already Exists'"
            sh "oc new-build --binary --name=ssi -l app=ssi || echo 'Build exists'"
			sh "oc start-build ssi --from-dir=. --follow"
			sh "oc new-app ssi -l app=ssi,hystrix.enabled=true || echo 'Application already Exists'"
			sh "oc expose service ssi"
            echo "This is the build number: ${env.BUILD_NUMBER}"
        }
    
       /* stage ('Automated tests'){
            echo 'This stage simulates automated tests'
            sh "mvn -B -Dmaven.test.failure.ignore test"
        }
    
        
        stage ('QA - Promote image'){
            echo 'Deploying to QA'
            promoteImage('helloworld-msa-dev', 'helloworld-msa-qa', 'aloha', 'latest')
        }
    
        stage ('Wait for approval'){
            input 'Approve to production?'
        }
    
        stage ('PRD - Promote image'){
            echo 'Deploying to production'
            promoteImage('helloworld-msa-qa', 'helloworld-msa', 'aloha', env.BUILD_NUMBER)
        }

        stage ('PRD - Canary Deploy'){
            echo 'Performing a canary deployment'
            canaryDeploy('helloworld-msa', 'aloha', env.BUILD_NUMBER)
        }
        */

    }
}
