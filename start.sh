sudo docker network create netMCt
sudo docker build -t $1 .
sudo docker run --network=netMCt -p $2:$2 --name=$1 $1 &
