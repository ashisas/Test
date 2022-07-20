pipeline
{
  agent any

   stages {
          stage('build'){
                  withMaven(maven: 'mvn') {
                      sh "mvn clean package"
                  }
              }
          stage('Build') {
              steps {
                  // Get some code from a GitHub repository
                  git 'https://github.com/ashisas/Test.git'

                  // Run Maven on a Unix agent.
                  sh "mvn -Dmaven.test.failure.ignore=true clean package"

                  // To run Maven on a Windows agent, use
                  // bat "mvn -Dmaven.test.failure.ignore=true clean package"
                  }
              }
    stage ('Sonar')
    {
      steps
      {
        sh 'mvn sonar:sonar'
      }
    }
  }
}