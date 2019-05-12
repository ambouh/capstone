import axios from 'axios';

class Auth {
    constructor(){
        this.authenticated = false;
    }
    development = 'http://localhost:3000/';

    login(username, password, callback) {
        //const requestOption = "person_id="+ username + "&password=" + password;
        const verb = '';
        const URL = this.getURL();
        const ax = axios.create({
            baseURL: URL
        });
        ax.get('person.json')
            .then((response) =>{
                const data = response.data;
                const user = this.getUser(username, data);

                if(user){
                    const data = {
                        "PERSON_ID": user.PERSON_ID,
                        "USERNAME" : user.USERNAME,
                        "AUTHENTICATED" : true
                    };

                    localStorage.setItem("user", JSON.stringify(data));
                    localStorage.setItem("person_id", user.PERSON_ID);
                    this.authenticated= true;
                    let response = {
                        status: "SUCCESS",
                        data: {}
                    };
                    callback(response);
                } else {
                    let response = {
                        status: "FAIL",
                        data: {}
                    };
                    return callback(response);
                }
            }).catch();
    }

    logout(callback) {
        localStorage.removeItem("user");
        localStorage.removeItem("person_id");
        this.authenticated = false;
        callback();
    }

    isAuthenticated() {
        return this.authenticated;
    }


    getUser(username, data){
        for(let i=0; i < data.length; i++ ){
            return (data[i].USERNAME === username)? data[i] : false ;
        }
    }

    getURL() {
        const production = "https://ambouh.github.io/transaxions/";
        const development = 'http://localhost:3000/';
        const localServer = "http://localhost:60080/api";
        return development;
    }

}

export default new Auth();