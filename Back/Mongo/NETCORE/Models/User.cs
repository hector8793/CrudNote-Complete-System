using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;
using Newtonsoft.Json;

namespace NETCORE.Models
{
    public class User
    {
        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string id { get; set; }

        [BsonElement("name")]
        [JsonProperty("name")]
        public string name { get; set; }

        public string email { get; set; }

        public string pwd { get; set; }
    }
}