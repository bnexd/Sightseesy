import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";
import app from "./firebase";

export const AuthContext = React.createContext();

export const AuthProvider = ({ children }) => {
    const [currentUser, setCurrentUser] = useState(null);
    useEffect(() => {
        app.auth().onAuthStateChanged(setCurrentUser);
    }, []);
    return (
        <AuthContext.Provider value={{ currentUser }}>
            <Router>
                <div className="App">
                    <Header user={{ ...currentUser }} />
                    <Route path="/" component={Feed}>
                        <Route exact path="/register" component={Register} />
                        <Route
                            exact
                            path="/profile"
                            component={currentUser => (
                                <Profile
                                    {...currentUser}
                                    user={"Email: " + currentUser.email}
                                />
                            )}
                        />
                        <Route
                            exact
                            path="/complete"
                            component={currentUser => (
                                <Register2
                                    {...currentUser}
                                    user={currentUser}
                                />
                            )}
                        />
                        <Route exact path="/login" component={Login} />
                        <Route exact path="/feed" component={Feed} />
                        <Route exact path="/inbox" component={Inbox} />
                        <Route exact path="/signout" component={SignOut} />
                    </Route>
                </div>
            </Router>
        </AuthContext.Provider>
    );
};
