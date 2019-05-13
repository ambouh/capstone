import axios from 'axios';

class Auth {
    development = 'http://localhost:3000/';

    login(username, password, callback) {
        const requestOption = "username="+ username + "&password=" + password;
        const verb = '';
        const URL = this.getURL();
        const ax = axios.create({
            baseURL: URL
        });
        ax.get('login?' + requestOption)
            .then((response) =>{
                const data = response.data;

                if(data) {
                    localStorage.setItem("person_id", data);

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
        localStorage.removeItem("person_id");
        callback();
    }

    isAuthenticated() {
        return localStorage.getItem("person_id")!=null;
    }



    getURL() {
        const localServer = "http://localhost:60080/api";
        return localServer;
    }

}

export default new Auth();