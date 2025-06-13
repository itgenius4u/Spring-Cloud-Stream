# Spring-Cloud-Stream

## Host OS(자기 사용하는 PC: Windows 11) 설치 사항
### VirtualBox 설치
    https://download.virtualbox.org/virtualbox/7.1.10/VirtualBox-7.1.10-169112-Win.exe
    - 설치후 재부팅 추천
    - 설치시 만일 Visual C++ 배포 패키지를 설치하라는 메세지가 나오면
      https://aka.ms/vs/17/release/vc_redist.x64.exe 다운로드후 설치후 VirtualBox 재설치
### VirtualBox Custom Nat네트워크 설정 및 포트 포워딩
    이름: NatNetwork
    IPv4 접두사: 192.168.15.0/24
    DHCP 활성화: off

    호스트 포트: 22001
    게스트 IP: 192.168.15.11
    게스트 포트: 22
    
### Visual Studio Code 설치
    https://code.visualstudio.com/download
    - 다운로드후 설치(경로는 적당한 곳으로 설정)
    
### Visual Studio Code Extension 설치
    - Korean Language Pack for Visual Studio Code 설치
    - Remote - SSH 설치
    
### Ubuntu 22.04.x 이미지 공유 경로에서 VirtualBox 이미지 다운로드
    https://drive.google.com/drive/folders/1vNSWT92fm9KSfAg8z9sqc2dsKI6hNfBo?usp=drive_link
    - Ubuntu 22.04.x
    - Git, Vim, Nano, Java 17 설치 및 환경 변수

### Ubuntu 22.04.x 이미지 다운로드 후 설정 및 확인
    - VirtualBox에서 다운받은 이미지를 클릭해서 등록
    - 네트워크 설정에 가서 NatNetwork로 선택(만일 안되어있는 경우 선택 및 확인)
    - 시스템 메뉴로 이동해서 기본 프로세서(2EA), 기본 메모리(8192MB)인지 확인    

### Visual Studo Code Remote SSH 설정
    - C:\Users\사용자\.ssh 폴터가 없는 경우 생성
    - C:\Users\사용자\.ssh에 id_rsa를 복사
    - 파일명: config -> 밑의 내용 추가후 저장
        Host ubuntusvr
            HostName localhost
            Port 22001
            User user1
            IdentityFile C:\Users\사용자\.ssh\id_rsa         
    => "사용자"는 사용하는 Users(사용자)폴더의 명칭 즉 로그인 아이디임.
    => Visual Studio Code Remote SSH 설정 방법으로도 가능함


## Guest OS(Ubuntu VM: Ubuntu 22.04.x)
    - Visual Studio Code Remote SSH로 접속 후
### Docker 설치
    https://docs.docker.com/engine/install/ubuntu/
        - Install using the apt repository
            1, 2, 3 실행        
    https://docs.docker.com/engine/install/linux-postinstall/
        - Manage Docker as a non-root user
            1, 2, 3, 4 실행    
    설치후 꼭 실행
    sudo chmod 666 /var/run/docker.sock 

## 기타 참고 설정
    - docker-compose-kafka.yml
        services:
          zookeeper:
            image: confluentinc/cp-zookeeper:7.4.4
            environment:
              ZOOKEEPER_CLIENT_PORT: 2181
              ZOOKEEPER_TICK_TIME: 2000
            ports:
              - 22181:2181
          
          kafka:
            image: confluentinc/cp-kafka:7.4.4
            depends_on:
              - zookeeper
            ports:
              - 29092:29092
            environment:
              KAFKA_BROKER_ID: 1
              KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
              KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:9092,PLAINTEXT_HOST://localhost:29092
              KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
              KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
              KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
        
          kafka-ui:
            container_name: kafka-ui
            image: provectuslabs/kafka-ui:latest
            ports:
              - 9090:8080
            depends_on:
              - kafka
            environment: 
              DYNAMIC_CONFIG_ENABLED: 'true'
              KAFKA_CLUSTERS_0_NAME: local
              KAFKA_CLUSTERS_0_BOOTSTRAPSERVERS: kafka:9092
              KAFKA_CLUSTERS_0_ZOOKEEPER: zookeeper:2181

    - Maven 
              sudo apt install maven
    
    - Git config(Local)
    
              git config user.name 아이디"
              git config user.email "메일주소"
    
    
    - Git config(Global)
    
              git config --global user.name "아이디"
              git config --global user.email "메일주소"
    
    - Git Management
    
              git config --list
              git config --unset user.name
              git config --unset user.email
    
              git config --unset --global user.name
              git config --unset --global user.email
    
              git remote -v
              git push --force myapp-test
              
              git config credential.helper store
              git config credential.helper store --global
              
              git config --unset credential.helper
              git config --global --unset credential.helper
    
    
    - Generate SSH Key
     
              ssh-keygen -t rsa -b 4096
              cd ~/.ssh
              cat id_rsa.pub >> ~/.ssh/authorized_keys
              cat authorized_keys
              cat id_rsa
              # Usage Visual Studio Code
              copy id_rsa on Host Windows(C:\Users\사용자\.ssh)
    
    - Docker Security Issues
    
              // Security Issues 
              sudo chmod 666 /var/run/docker.sock or sudo chown root:docker /var/run/docker.sock
