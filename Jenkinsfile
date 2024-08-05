#!groovy
import java.text.SimpleDateFormat

def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def date = new Date()
def timestamp = dateFormat.format(date).toString()

pipeline {
    agent any
    stages {
        stage('Get Sources') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: "master"]],
                          wdoGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: "GitPerson", url: "https://github.com/mike7019/HealeniumProxy.git"]]])
            }
        }

        stage('Execute Tests') {
            steps {
                script {
                    try {
                        //bat ("gradle clean test -DRunner=\"${Runner}\" aggregate")
                        //sh ("gradle clean test -DRunner=\"${Runner}\" aggregate")
                        //bat("gradle clean test -Dwebdriver.remote.url=http://127.0.0.1:4444/wd/hub")
                        bat("gradle clean test -Dwebdriver.remote.url=http://127.0.0.1:8085")
                        echo 'Test executed successfully'
                        currentBuild.result = 'SUCCESS'
                    } catch (ex) {
                        echo 'Test executed with failures'
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }
        
        stage('Generate Reports') {
            steps {
                script {
                    def backupDir = "${WORKSPACE}\\target".replace('\\', '/')
                    def timestampDir = "serenity_${timestamp}"
                    def targetDir = "${WORKSPACE}/${timestampDir}"

                    try {
                        bat "rename \"${backupDir}\" ${timestampDir}"
                        echo 'evidences backed up successfully'

                        publishHTML([allowMissing         : false,
                                     alwaysLinkToLastBuild: true,
                                     keepAll              : true,
                                     reportDir            : targetDir,
                                     reportFiles          : 'index.html',
                                     reportName           : 'Evidences Hackaton',
                                     reportTitles         : 'Project Hackaton Screenplay'])
                        echo 'HTML report generated successfully'
                    } catch (e) {
                        echo 'could not backup the evidences'
                        publishHTML([allowMissing         : false,
                                     alwaysLinkToLastBuild: true,
                                     keepAll              : true,
                                     reportDir            : "${WORKSPACE}/target/${timestampDir}",
                                     reportFiles          : 'index.html',
                                     reportName           : 'Evidences Hackaton',
                                     reportTitles         : 'Project Hackaton Screenplay'])
                        echo 'HTML report generated successfully'
                        currentBuild.result = 'SUCCESS'
                    }
                }
            }
        }
    }
}
