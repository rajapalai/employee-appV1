pipeline {
	agent any
	tools {
		maven 'maven'
	}
	stages {
		stage ('Checkout SCM'){
			steps {
				checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [
						[credentialsId: 'github', url: 'https://github.com/rajapalai/employee-appV1']
					]])
				sh 'mvn clean install'
			}
		}
		stage ('Maven Build') {
			steps {
				sh 'mvn package'
			}
		}

		stage ('Jfrog Artifactory Configuration') {
			steps {
				rtServer (
						id: "jfrog",
						url: "http://34.228.64.200:8082/artifactory",
						credentialsId: "jfrog"
						)

				rtMavenDeployer (
						id: "MAVEN_DEPLOYER",
						serverId: "jfrog",
						releaseRepo: "libs-release-local",
						snapshotRepo: "libs-snapshot-local"
						)

				rtMavenResolver (
						id: "MAVEN_RESOLVER",
						serverId: "jfrog",
						releaseRepo: "libs-release",
						snapshotRepo: "libs-snapshot"
						)
			}
		}
		stage ('Jfrog Artifactory Deployment') {
			steps {
				rtMavenRun (
						tool: "maven",
						pom: 'pom.xml',
						goals: 'clean install deploy',
						deployerId: "MAVEN_DEPLOYER",
						resolverId: "MAVEN_RESOLVER"
						)
			}
		}
		stage ('Deploy Artifacts Into libs-release-local File') {
			steps {
				rtUpload (
						serverId: "jfrog",
						spec: '''{
		 						"files" : [
		 							{
		 							"pattern" : "employee-appV1.jar",
		 							"target" : "libs-release-local"
		 							}
		 						]
		 					}''',
						)
			}
		}

		stage ('Publish Build Info') {
			steps {
				rtPublishBuildInfo (
						serverId: "jfrog"
						)
			}
		}
		stage ('Build Docker Image') {
		    steps {
		        script {
		            sh 'docker build -t rajapalai/employee-appV1 .'
		        }
		    }
		}
		stage ('Push Docker Image To Docker Hub Repository') {
            steps {
        		script {
        		    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
        		        sh 'docker login -u rajapalai -p ${dockerhubpwd}'
                    }
                        sh 'docker push rajapalai/employee-appv1'
        		}
        	}
        }
	}
}
