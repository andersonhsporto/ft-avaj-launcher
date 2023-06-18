echo "installing java"

read -p "Do you want to install java 17 ? [Y/n]" -n 1 -r
echo    # (optional) move to a new line
if [[ ! $REPLY =~ ^[Yy]$ ]] # if user input is not Y or y
then
	echo "skipping java installation"
	exit 1
fi

# update repository
sudo apt-get update

# install java + javac ( JDK )
sudo apt install openjdk-17-jdk-headless