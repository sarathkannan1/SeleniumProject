pipeline 
{
    agent any

    stages 
    {
        stage('Build') 
        {
            steps 
            {
               git 'https://github.com/sarathkannan1/SeleniumProject.git'
               bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        
            post
            {
                  success
                  {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                  }
             }
    
   
          }
    }
}
