using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;

namespace NETCORE.Models
{
    public class User
    {
        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string Id { get; set; }

        [BsonElement("Name")]
        public string Name { get; set; }

        public decimal Email { get; set; }

        public string Pwd { get; set; }
    }
}