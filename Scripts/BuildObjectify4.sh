#!/bin/sh

WORKING_DIRECTORY=~/objectify-workspace

if [ ! -d $WORKING_DIRECTORY ]; then
    mkdir $WORKING_DIRECTORY
fi

# change to the working directory to perform the operations
cd $WORKING_DIRECTORY




# get GAE
curl http://googleappengine.googlecode.com/files/appengine-java-sdk-1.6.6.zip >> appengine-java-sdk-1.6.6.zip

# extract GAE
unzip -o appengine-java-sdk-1.6.6.zip

# get GWT
curl http://google-web-toolkit.googlecode.com/files/gwt-2.4.0.zip >> gwt-2.4.0.zip

# extract GWT
unzip -o gwt-2.4.0.zip



# get the objectify source
if [ ! -d $WORKING_DIRECTORY/objectify-appengine ]; then
	git clone https://code.google.com/p/objectify-appengine/ 
	cd objectify-appengine
else
	cd objectify-appengine
	git reset --hard HEAD
	git pull
fi

# GAE sdk directory
GAESDKDIR="$WORKING_DIRECTORY/appengine-java-sdk-1.6.6"
GWTSDKDIR="$WORKING_DIRECTORY/gwt-2.4.0"
EDITANTBUILDPROPETIES="$WORKING_DIRECTORY/objectify-appengine/edit-this-to-build.properties"

#change value for GAE sdk directory
echo "gae.sdk.dir=$GAESDKDIR\ngwt.sdk.dir=$GWTSDKDIR\n" > $EDITANTBUILDPROPETIES

ant