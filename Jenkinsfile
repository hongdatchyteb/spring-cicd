pipeline {
    agent any
    stages {
    stage('Clone') {
                steps {
                    script {
                        // Di chuyển đến thư mục dự án
                        dir('/home/hongdatchy') {
                            // Pull latest code from git
                            sh 'rm -r -f /home/hongdatchy/simple_spring'
                            sh 'git clone https://github.com/hongdatchy/simple_spring'

                        }
                    }
                }
            }
        stage('Build') {
            steps {
                script {
                    // Di chuyển đến thư mục dự án
                    dir('/home/hongdatchy/simple_spring') {
                        // Build project using Maven
                        sh 'mvn clean install'
                    }
                }
            }
        }
        stage('Run') {
            steps {
                script {
                    // Di chuyển đến thư mục dự án
                    dir('/home/hongdatchy/simple_spring') {
                        // Dừng tiến trình Spring Boot cũ nếu có
                        sh '''
                            # Tìm PID của tiến trình sử dụng cổng 8083 (hoặc cổng khác nếu bạn đã thay đổi)
                            PID=$(lsof -ti:8083 || true)

                            # Nếu PID tồn tại, dừng tiến trình
                            if [ ! -z "$PID" ]; then
                                echo "Dừng tiến trình cũ với PID $PID"
                                kill -9 $PID
                            fi
                        '''

                        // Khởi động ứng dụng mới
                        sh "JENKINS_NODE_COOKIE=dontKillMe nohup java -jar target/SimpleSpring-0.0.1-SNAPSHOT.jar > app.log 2>&1 &"
                    }
                }
            }
        }
    }
}
