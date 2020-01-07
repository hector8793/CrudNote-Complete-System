using NETCORE.Models;
using MongoDB.Driver;
using System.Collections.Generic;
using System.Linq;

namespace NETCORE.Services
{
    public class UserService
    {
        private readonly IMongoCollection<User> _users;

        public UserService(IUserstoreDatabaseSettings settings)
        {
            var client = new MongoClient(settings.ConnectionString);
            var database = client.GetDatabase(settings.DatabaseName);

            _users = database.GetCollection<User>(settings.UsersCollectionName);
        }

        public List<User> Get() =>
            _users.Find(User => true).ToList();

        public User Get(string id) =>
            _users.Find<User>(User => User.id == id).FirstOrDefault();

        public User Create(User User)
        {
            _users.InsertOne(User);
            return User;
        }

        public void Update(string id, User UserIn) =>
            _users.ReplaceOne(User => User.id == id, UserIn);

        public void Remove(User UserIn) =>
            _users.DeleteOne(User => User.id == UserIn.id);

        public void Remove(string id) => 
            _users.DeleteOne(User => User.id == id);
    }
}